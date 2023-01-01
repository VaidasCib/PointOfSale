package dropdatabase.pos.impl.arrangement.arrangements;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.arrangement.timeslots.Timeslot;
import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.employees.employee.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "arrangements")
public class Arrangement extends BaseEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_arrangements",
            joinColumns = @JoinColumn(name = "arrangements_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeesPresent;

    ///@ManyToMany(cascade=CascadeType.ALL)
    ///@JoinColumn(name="payment_id", referencedColumnName = "id")
    ///private List<Discount> discount;

    ///@ManyToOne
    ///@JoinColumn(name="payment_id", referencedColumnName = "id")
    ///private Payment payment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "timeslot_arrangements",
            joinColumns = @JoinColumn(name = "arrangements_id"),
            inverseJoinColumns = @JoinColumn(name = "timeslot_id"))
    private Set<Timeslot> timeslotsPresent;
    @Column(name = "tips")
    private Double tips;
    @Column(name = "specifications")
    private String specifications;
}
