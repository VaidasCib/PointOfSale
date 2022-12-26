package dropdatabase.pos.impl.core.merchant;

import dropdatabase.pos.impl.core.merchant.dto.MerchantDto;
import dropdatabase.pos.impl.core.merchant.dto.MerchantPutDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Api(tags={"Merchant controller"})
@Path("/merchant")
@Consumes(MediaType.APPLICATION_JSON)
public class MerchantController {
    @Inject
    private MerchantService merchantService;

    @GET
    @Path("/{merchant_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MerchantDto getById(@PathParam("merchant_id") UUID merchantId) {
        return merchantService.getById(merchantId);
    }

    @PUT
    @Path("/{merchant_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("merchant_id") UUID merchantId, MerchantPutDto merchantPutDto) {
        merchantService.put(merchantId, merchantPutDto);
        return Response.status(200).entity("Merchant updated successfully").build();
    }

}
