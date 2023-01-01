package dropdatabase.pos.impl.arrangement.timeslots;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.arrangement.services.Services;
import dropdatabase.pos.impl.category.Category;
import dropdatabase.pos.impl.employees.employee.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "timeslots")
public class Timeslot extends BaseEntity {
    public enum Status {
        Open,
        Booked,
        In_progress,
        Completed,
        Cancelled
    }

    @Column(name = "status")
    private String status;
    @Column(name = "slot_from")
    private Date slot_from;
    @Column(name = "slot_to")
    private Date slot_to;
    @Column(name = "location")
    private String location;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_timeslots",
            joinColumns = @JoinColumn(name = "timeslot_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employeesPresent;

    @ManyToOne
    @JoinColumn(name="services", referencedColumnName = "id")
    private Services services;
}
