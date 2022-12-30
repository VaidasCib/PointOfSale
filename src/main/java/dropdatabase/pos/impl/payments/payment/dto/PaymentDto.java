package dropdatabase.pos.impl.payments.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class PaymentDto {
    private UUID id;
    private String payment_type;
    private String payment_status;
    private BigDecimal total;
    private BigDecimal tax;
    private Date paid_time;
}
