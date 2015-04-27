package app.controller;

import common.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("jersey-app");
        EntityManager em = fac.createEntityManager();
        return "employee";
    }

    @GET
    @Path("/insert")
    @Produces(MediaType.TEXT_PLAIN)
    public String put() {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("jersey-app");
        EntityManager em = fac.createEntityManager();

        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setEmployId(1);
        employee.setMail("h-hasegawa@tads.co.jp");
        employee.setName("長谷川 寛");
        employee.setPassword("00000000");
        em.persist(employee);

        em.getTransaction().commit();

        return "OK";
    }

}
