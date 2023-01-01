package dropdatabase.pos.impl.arrangement.timeslots;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementDto;
import dropdatabase.pos.impl.arrangement.timeslots.dto.TimeslotDto;
import dropdatabase.pos.impl.arrangement.timeslots.dto.TimeslotPostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Timeslot controller"})
@Path("/timeslot")
@Consumes(MediaType.APPLICATION_JSON)
public class TimeslotController {
    @Inject
    private TimeslotService timeslotService;
    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(TimeslotPostDto timeslotPostDto) {
        timeslotService.post(timeslotPostDto);
        return Response.status(200).entity("Timeslot created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimeslotDto> getAll() {
        return timeslotService.getAll();
    }

    @PUT
    @Path("/{timeslot_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("timeslot_id") UUID timeslotId, TimeslotPostDto timeslotPostDto) {
        timeslotService.put(timeslotId, timeslotPostDto);
        return Response.status(200).entity("Timeslot updated successfully").build();
    }

    @DELETE
    @Path("/{timeslot_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("timeslot_id") UUID timeslotId) {
        timeslotService.delete(timeslotId);
        return Response.status(200).entity("Timeslot deleted successfully").build();
    }
}
