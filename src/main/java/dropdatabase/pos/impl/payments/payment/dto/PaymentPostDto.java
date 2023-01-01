package dropdatabase.pos.impl.payments.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class PaymentPostDto {
    private String paymentType;
    private String paymentStatus;
    private BigDecimal total;
    private BigDecimal tax;
    private Date paidTime;
}
