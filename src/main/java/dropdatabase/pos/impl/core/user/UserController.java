package dropdatabase.pos.impl.core.user;

import dropdatabase.pos.impl.core.user.dto.UserDto;
import dropdatabase.pos.impl.core.user.dto.UserPostDto;
import dropdatabase.pos.impl.core.user.dto.UserPutDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Api(tags={"Users controller"})
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(UserPostDto userPostDto) {
        userService.post(userPostDto);
        return Response.status(200).entity("User created successfully").build();
    }

    @GET
    @Path("/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUser(@PathParam("user_id") UUID userId) {
        return userService.getById(userId);
    }

    @PUT
    @Path("/{user_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("user_id") UUID userId, UserPutDto userPutDto) {
        userService.put(userId, userPutDto);
        return Response.status(200).entity("User updated successfully").build();
    }
}
