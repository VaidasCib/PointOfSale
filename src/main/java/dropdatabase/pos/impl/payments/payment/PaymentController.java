package dropdatabase.pos.impl.payments.payment;

import dropdatabase.pos.impl.payments.payment.dto.PaymentDto;
import dropdatabase.pos.impl.payments.payment.dto.PaymentPostDto;
import io.swagger.annotations.Api;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Api(tags={"Payment controller"})
@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentController {

}
