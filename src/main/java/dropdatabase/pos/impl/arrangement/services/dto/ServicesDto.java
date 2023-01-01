package dropdatabase.pos.impl.arrangement.services.dto;

import dropdatabase.pos.impl.category.Category;
import dropdatabase.pos.impl.payments.taxes.Taxes;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class ServicesDto {
    private UUID id;

    private String name;

    private String description;

    private Category category;

    private BigDecimal price;

    private List<Taxes> taxesPresent;
}
