package dropdatabase.pos.impl.arrangement.arrangements;

import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementDto;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementPostDto;
import dropdatabase.pos.impl.arrangement.arrangements.dto.ArrangementPutDto;
import dropdatabase.pos.impl.arrangement.services.ServicesService;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPostDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPutDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Arrangement controller"})
@Path("/arrangement")
@Consumes(MediaType.APPLICATION_JSON)
public class ArrangementController {
    @Inject
    private ArrangementService arrangementService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(ArrangementPostDto arrangementPostDto) {
        arrangementService.post(arrangementPostDto);
        return Response.status(200).entity("Arrangement created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArrangementDto> getAll() {
        return arrangementService.getAll();
    }

    @GET
    @Path("/{arrangement_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrangementDto getById(@PathParam("arrangement_id") UUID arrangementId) {
        return arrangementService.getById(arrangementId);
    }

    @PUT
    @Path("/{arrangement_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("arrangement_id") UUID arrangementId, ArrangementPutDto arrangementPutDto) {
        arrangementService.put(arrangementId, arrangementPutDto);
        return Response.status(200).entity("Arrangement updated successfully").build();
    }

    @DELETE
    @Path("/{arrangement_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("arrangement_id") UUID arrangementId) {
        arrangementService.delete(arrangementId);
        return Response.status(200).entity("Arrangement deleted successfully").build();
    }

    @POST
    @Path("/{arrangement_id}/timeslots/{timeslot_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmployeeToShift(@PathParam("arrangement_id") UUID arrangementId,
                                       @PathParam("timeslot_id") UUID timeslotId) {
        arrangementService.addTimeslotToArrangement(arrangementId, timeslotId);
        return Response.status(200).entity("Timeslot added successfully to the arrangement").build();
    }

    @DELETE
    @Path("/{arrangement_id}/timeslots/{timeslot_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response removeEmployeeFromShift(@PathParam("arrangement_id") UUID arrangementId,
                                            @PathParam("timeslot_id") UUID timeslotId) {
        arrangementService.removeTimeslotFromArrangement(arrangementId, timeslotId);
        return Response.status(200).entity("Timeslot removed successfully from the arrangement").build();
    }
}
