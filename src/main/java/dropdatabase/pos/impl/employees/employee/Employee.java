package dropdatabase.pos.impl.employees.employee;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.employees.role.Role;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role role;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "on_holiday")
    private Boolean onHoliday;
}
