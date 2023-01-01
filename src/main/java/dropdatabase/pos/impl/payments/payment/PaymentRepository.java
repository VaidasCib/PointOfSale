package dropdatabase.pos.impl.payments.payment;

import dropdatabase.pos.common.Repository;
import dropdatabase.pos.impl.employees.shift.Shift;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class PaymentRepository extends Repository<Payment> {
    public PaymentRepository() {
        super(Payment.class);
    }
}
