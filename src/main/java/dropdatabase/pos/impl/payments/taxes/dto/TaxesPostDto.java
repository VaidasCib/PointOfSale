package dropdatabase.pos.impl.payments.taxes.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxesPostDto {
    private String name;
    private BigDecimal tax_percentage;
}
