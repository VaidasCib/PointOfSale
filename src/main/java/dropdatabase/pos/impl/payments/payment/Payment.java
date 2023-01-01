package dropdatabase.pos.impl.payments.payment;

import lombok.Data;
import dropdatabase.pos.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity{
    public enum PaymentType{
        cash,
        card,
        internetBank,
    }
    public enum PaymentStatus{
        received,
        failed,
        inProgress,
    }
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "tax")
    private BigDecimal tax;
    @Column(name = "paid_time")
    private Date paid_time;
}
