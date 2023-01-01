package dropdatabase.pos.impl.category;

import dropdatabase.pos.common.Repository;
import dropdatabase.pos.impl.employees.role.Role;

import javax.ejb.Singleton;

@Singleton
public class CategoryRepository extends Repository<Category> {
    public CategoryRepository() {
        super(Category.class);
    }
}
