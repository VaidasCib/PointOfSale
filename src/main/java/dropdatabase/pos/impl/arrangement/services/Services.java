package dropdatabase.pos.impl.arrangement.services;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.category.Category;
import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.employees.employee.Employee;
import dropdatabase.pos.impl.payments.taxes.Taxes;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "services")
public class Services extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="category", referencedColumnName = "id")
    private Category category;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "service_taxes",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "taxes_id"))
    private Set<Taxes> taxesPresent;
}
