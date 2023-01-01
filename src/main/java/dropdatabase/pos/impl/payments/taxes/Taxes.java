package dropdatabase.pos.impl.payments.taxes;

import dropdatabase.pos.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@Table(name = "taxes")
public class Taxes extends BaseEntity{
    @Column(name = "total")
    private String name;
    @Column(name = "tax")
    private BigDecimal tax_percentage;
}
