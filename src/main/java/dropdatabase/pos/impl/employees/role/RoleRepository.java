package dropdatabase.pos.impl.employees.role;

import dropdatabase.pos.common.Repository;

import javax.ejb.Singleton;

@Singleton
public class RoleRepository extends Repository<Role> {
    public RoleRepository() {
        super(Role.class);
    }
}

