package dropdatabase.pos.impl.payments.taxes.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TaxesDto {
    private UUID id;
    private String name;
    private BigDecimal tax_percentage;
}