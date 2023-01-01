package dropdatabase.pos.impl.payments.discount;

import dropdatabase.pos.common.Repository;
import dropdatabase.pos.impl.payments.discount.Discount;

import javax.ejb.Singleton;

@Singleton
public class DiscountRepository extends Repository<Discount> {
    public DiscountRepository() {
        super(Discount.class);
    }
}
