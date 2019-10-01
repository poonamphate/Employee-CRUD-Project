package com.demoREST.RESTfulCRUD_Employee.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demoREST.RESTfulCRUD_Employee.dao.EmployeeDAO;
import com.demoREST.RESTfulCRUD_Employee.model.Employee;
import com.demoREST.RESTfulCRUD_Employee.model.Response;

@Path("/employees")
public class EmployeeService {
	 
    //URI:/RESTfulCRUD_Employee/rest/employees
	//REST API to read all employees from database
	@GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployees() {
        List<Employee> listOfEmployees = EmployeeDAO.selectEmployeesFromDB();
        return listOfEmployees;
    }
	
    //URI:/RESTfulCRUD_Employee/rest/employees/{empId}
    @GET
    //REST API to read employee by id from database
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee getEmployee(@PathParam("id") int id) {
        return EmployeeDAO.selectEmployeeFromDB(id);
    }
    
    //URI:/RESTfulCRUD_Employee/rest/employees
    //REST API to Create a new employee record in the database
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addEmployee(Employee emp) {
        return (EmployeeDAO.insertEmployeeInDB(emp) ? new Response(0) : new Response(-1));
    }
    
    //URI:/RESTfulCRUD_Employee/rest/employees
    //REST API to update an existing employee record in the database
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateEmployee(Employee emp) {
        return (EmployeeDAO.updateEmployeeInDB(emp) ? new Response(0) : new Response(-1));
    }
 
   //URI:/RESTfulCRUD_Employee/rest/employees/{empId}
   //REST API to delete an existing employee record in the database
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteEmployee(@PathParam("id") int id) {
        return (EmployeeDAO.deleteEmployeeInDB(id) ? new Response(0) :new Response(-1));
    }
	
}
