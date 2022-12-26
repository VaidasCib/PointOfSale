package dropdatabase.pos.impl.employees.shift;

import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftPostDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftPutDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(tags={"Shifts controller"})
@Path("/shifts")
@Consumes(MediaType.APPLICATION_JSON)
public class ShiftController {
    @Inject
    private ShiftService shiftService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(ShiftPostDto shiftPostDto) {
        shiftService.post(shiftPostDto);
        return Response.status(200).entity("Shift created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShiftDto> getList(@ApiParam(format = "date-time")
                                  @QueryParam("minDate") Date minDate,
                                  @ApiParam(format = "date-time")
                                  @QueryParam("maxDate") Date maxDate,
                                  @QueryParam("stateHoliday") Boolean stateHoliday,
                                  @QueryParam("weekday") String weekDay) {
        return shiftService.getList(minDate, maxDate, stateHoliday, weekDay);
    }

    @GET
    @Path("/{shift_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShiftDto getById(@PathParam("shift_id") UUID shiftId) {
        return shiftService.getById(shiftId);
    }

    @PUT
    @Path("/{shift_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getById(@PathParam("shift_id") UUID shiftId, ShiftPutDto shiftPutDto) {
        shiftService.put(shiftId, shiftPutDto);
        return Response.status(200).entity("Shift updated successfully").build();
    }

    @DELETE
    @Path("/{shift_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("shift_id") UUID shiftId) {
        shiftService.delete(shiftId);
        return Response.status(200).entity("Shift deleted successfully").build();
    }

    @POST
    @Path("/{shift_id}/employees/{employee_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmployeeToShift(@PathParam("shift_id") UUID shiftId,
                                       @PathParam("employee_id") UUID employeeId) {
        shiftService.addEmployeeToShift(shiftId, employeeId);
        return Response.status(200).entity("Employee added successfully to the shift").build();
    }

    @DELETE
    @Path("/{shift_id}/employees/{employee_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response removeEmployeeFromShift(@PathParam("shift_id") UUID shiftId,
                                       @PathParam("employee_id") UUID employeeId) {
        shiftService.removeEmployeeFromShift(shiftId, employeeId);
        return Response.status(200).entity("Employee removed successfully from the shift").build();
    }

}
