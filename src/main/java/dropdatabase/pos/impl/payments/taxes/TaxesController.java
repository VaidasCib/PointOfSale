package dropdatabase.pos.impl.payments.taxes;

import dropdatabase.pos.impl.employees.employee.dto.EmployeeDto;
import dropdatabase.pos.impl.employees.employee.dto.EmployeePostDto;
import dropdatabase.pos.impl.employees.role.dto.RoleDto;
import dropdatabase.pos.impl.employees.role.dto.RolePostDto;
import dropdatabase.pos.impl.payments.taxes.dto.TaxesDto;
import dropdatabase.pos.impl.payments.taxes.dto.TaxesPostDto;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Api(tags={"Taxes controller"})
@Path("/taxes")
@Consumes(MediaType.APPLICATION_JSON)
public class TaxesController {
    @Inject
    private TaxesService taxesService;
    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(TaxesPostDto taxesPostDto) {
        taxesService.post(taxesPostDto);
        return Response.status(200).entity("Tax created successfully").build();
    }
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaxesDto> getAll() {
        return taxesService.getAll();
    }

    @PUT
    @Path("/{tax_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response put(@PathParam("tax_id") UUID taxId, TaxesPostDto taxesPostDto) {
        taxesService.put(taxId, taxesPostDto);
        return Response.status(200).entity("Tax updated successfully").build();
    }
    @DELETE
    @Path("/{tax_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("tax_id") UUID taxId) {
        taxesService.delete(taxId);
        return Response.status(200).entity("Tax deleted successfully").build();
    }
}