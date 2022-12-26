package dropdatabase.pos.impl.core.user;

import dropdatabase.pos.common.Repository;

public class UserRepository extends Repository<User> {
    public UserRepository() {
        super(User.class);
    }
}
