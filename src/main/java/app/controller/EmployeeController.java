package app.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
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

}
