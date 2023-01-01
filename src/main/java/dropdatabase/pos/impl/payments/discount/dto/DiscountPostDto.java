package dropdatabase.pos.impl.payments.discount.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class DiscountPostDto {
    //Nera applies_to_types
    private String name;
    private String discount_code;
    private BigDecimal discount_percentage;
    private Date valid_from;
    private Date valid_to;
}
