package dropdatabase.pos.impl.payments.discount;

import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;
import dropdatabase.pos.impl.payments.discount.DiscountService;
import dropdatabase.pos.impl.payments.discount.dto.DiscountDto;
import dropdatabase.pos.impl.payments.discount.dto.DiscountPostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Api(tags={"Discount controller"})
@Path("/discount")
@Consumes(MediaType.APPLICATION_JSON)
public class DiscountController {
    @Inject
    private DiscountService discountService;
    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(DiscountPostDto discountPostDto) {
        discountService.post(discountPostDto);
        return Response.status(200).entity("Discount created successfully").build();
    }
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiscountDto> getAll() {
        return discountService.getAll();
    }

    @GET
    @Path("/{discount_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DiscountDto getById(@PathParam("discount_id") UUID discountId) {
        return discountService.getById(discountId);
    }

    @PUT
    @Path("/{discount_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("discount_id") UUID discountId, DiscountPostDto discountPostDto) {
        discountService.put(discountId, discountPostDto);
        return Response.status(200).entity("Discount updated successfully").build();
    }
    @DELETE
    @Path("/{discount_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("discount_id") UUID discountId) {
        discountService.delete(discountId);
        return Response.status(200).entity("Discount deleted successfully").build();
    }
}
