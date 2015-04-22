package app.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "employee";
    }

}
