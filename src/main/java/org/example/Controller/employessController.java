package org.example.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.EmployeeDAO;
import org.example.models.employees;

import java.util.ArrayList;
@Path("/employees")
public class employessController {
    EmployeeDAO em = new EmployeeDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<employees> selectAllEmployees() {
        try {
            return em.selectAllEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GET
    @Path("{employee_id}")
    public employees selectEmployee(@PathParam("employee_id") int employee_id) {
        try {
            return em.selectEmployee(employee_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("{employee_id}")
    public void deleteEmployee(@PathParam("employee_id") int employee_id) {

        try {
            em.deleteEmployee(employee_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @POST
    public void insertEmployee(employees emp) {
        try {
            em.insertEmployee(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PUT
    @Path("{employee_id}")
    public void updateEmployee(@PathParam("employee_id") int employee_id, employees emp) {

        try {
            emp.setEmployee_id(employee_id);
            em.updateEmployee(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

