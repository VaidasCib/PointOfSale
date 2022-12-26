package dropdatabase.pos.impl.employees.role;

import dropdatabase.pos.impl.employees.role.dto.RoleDto;
import dropdatabase.pos.impl.employees.role.dto.RolePostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Roles controller"})
@Path("/roles")
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {
    @Inject
    private RoleService roleService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(RolePostDto rolePostDto) {
        roleService.post(rolePostDto);
        return Response.status(200).entity("Role created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleDto> getAll() {
        return roleService.getAll();
    }

    @PUT
    @Path("/{role_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("role_id") UUID roleId, RolePostDto rolePostDto) {
        roleService.put(roleId, rolePostDto);
        return Response.status(200).entity("Role updated successfully").build();
    }

    @DELETE
    @Path("/{role_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("role_id") UUID roleId) {
        roleService.delete(roleId);
        return Response.status(200).entity("Role deleted successfully").build();
    }
}
