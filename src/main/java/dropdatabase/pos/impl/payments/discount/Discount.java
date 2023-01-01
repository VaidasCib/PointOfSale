package dropdatabase.pos.impl.payments.discount;

import dropdatabase.pos.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
    //Nera applies_to_types
    @Column(name = "name")
    private String name;
    @Column(name = "discount_code")
    private String discount_code;
    @Column(name = "discount_percentage")
    private BigDecimal discount_percentage;
    @Column(name = "valid_from")
    private Date valid_from;
    @Column(name = "valid_to")
    private Date valid_to;
}
