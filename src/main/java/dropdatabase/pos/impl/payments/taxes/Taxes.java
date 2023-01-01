package dropdatabase.pos.impl.payments.taxes;

import dropdatabase.pos.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "taxes")
public class Taxes extends BaseEntity {
    @Column(name = "tax")
    private BigDecimal tax_percentage;
}
