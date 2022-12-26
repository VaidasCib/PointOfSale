package dropdatabase.pos.impl.core.merchant;

import dropdatabase.pos.common.Repository;

import javax.ejb.Singleton;

@Singleton
public class MerchantRepository extends Repository<Merchant> {
    public MerchantRepository() {
        super(Merchant.class);
    }
}

