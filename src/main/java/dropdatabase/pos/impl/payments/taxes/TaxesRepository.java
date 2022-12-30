package dropdatabase.pos.impl.payments.taxes;

import dropdatabase.pos.common.Repository;
import dropdatabase.pos.impl.employees.employee.Employee;
import dropdatabase.pos.impl.payments.taxes.Taxes;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Singleton;

@Singleton
public class TaxesRepository extends Repository<Taxes> {
    public TaxesRepository() {
        super(Taxes.class);
    }
}
