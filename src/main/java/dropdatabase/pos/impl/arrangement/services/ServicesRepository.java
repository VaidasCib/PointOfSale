package dropdatabase.pos.impl.arrangement.services;

import dropdatabase.pos.common.Repository;
import javax.ejb.Singleton;

@Singleton
public class ServicesRepository extends Repository<Services> {
    public ServicesRepository() {
        super(Services.class);
    }
}
