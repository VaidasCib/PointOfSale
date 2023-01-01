package dropdatabase.pos.impl.category;

import dropdatabase.pos.impl.category.categoryDto.CategoryDto;
import dropdatabase.pos.impl.category.categoryDto.CategoryPostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Category controller"})
@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {
    @Inject
    private CategoryService categoryService;

    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(CategoryPostDto categoryPostDto) {
        categoryService.post(categoryPostDto);
        return Response.status(200).entity("Category created successfully").build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @PUT
    @Path("/{category_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("category_id") UUID categoryId, CategoryPostDto categoryPostDto) {
        categoryService.put(categoryId, categoryPostDto);
        return Response.status(200).entity("Category updated successfully").build();
    }

    @DELETE
    @Path("/{category_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("category_id") UUID categoryId) {
        categoryService.delete(categoryId);
        return Response.status(200).entity("Category deleted successfully").build();
    }
}
