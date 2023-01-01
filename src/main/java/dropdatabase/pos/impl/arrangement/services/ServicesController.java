package dropdatabase.pos.impl.arrangement.services;

import dropdatabase.pos.impl.arrangement.services.dto.ServicesDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPostDto;
import dropdatabase.pos.impl.arrangement.services.dto.ServicesPutDto;
import dropdatabase.pos.impl.employees.role.RoleService;
import dropdatabase.pos.impl.employees.role.dto.RoleDto;
import dropdatabase.pos.impl.employees.role.dto.RolePostDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Services controller"})
@Path("/services")
@Consumes(MediaType.APPLICATION_JSON)
public class ServicesController {
    @Inject
    private ServicesService servicesService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(ServicesPostDto servicesPostDto) {
        servicesService.post(servicesPostDto);
        return Response.status(200).entity("Service created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServicesDto> getAll() {
        return servicesService.getAll();
    }

    @GET
    @Path("/{service_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ServicesDto getById(@PathParam("service_id") UUID servicesId) {
        return servicesService.getById(servicesId);
    }

    @PUT
    @Path("/{service_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("service_id") UUID servicesId, ServicesPutDto servicesPutDto) {
        servicesService.put(servicesId, servicesPutDto);
        return Response.status(200).entity("Services updated successfully").build();
    }

    @DELETE
    @Path("/{service_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("service_id") UUID servicesId) {
        servicesService.delete(servicesId);
        return Response.status(200).entity("Service deleted successfully").build();
    }
}
