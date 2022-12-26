package dropdatabase.pos.impl.employees.employee;

import dropdatabase.pos.impl.employees.employee.dto.EmployeeDto;
import dropdatabase.pos.impl.employees.employee.dto.EmployeePostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Api(tags={"Employees controller"})
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(EmployeePostDto employeePostDto) {
        employeeService.post(employeePostDto);
        return Response.status(200).entity("Employee created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDto> getByQueryParams(@QueryParam("minSalary") BigDecimal minSalary,
                                              @QueryParam("maxSalary") BigDecimal maxSalary,
                                              @QueryParam("roleId") UUID roleId,
                                              @QueryParam("onHoliday") Boolean onHoliday) {
        return employeeService.getList(minSalary, maxSalary, roleId, onHoliday);
    }

    @GET
    @Path("{employee_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto getById(@PathParam("employee_id") UUID employeeId) {
        return employeeService.getById(employeeId);
    }

    @PUT
    @Path("{employee_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("employee_id") UUID employeeId, EmployeePostDto employeePostDto) {
        employeeService.put(employeeId, employeePostDto);
        return Response.status(200).entity("Employee updated successfully").build();
    }
}
