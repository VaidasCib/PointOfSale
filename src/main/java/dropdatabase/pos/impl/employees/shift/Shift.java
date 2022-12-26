package dropdatabase.pos.impl.employees.shift;

import dropdatabase.pos.common.BaseEntity;
import dropdatabase.pos.impl.employees.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "shifts")
public class Shift extends BaseEntity {
    public enum WeekDay {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    }
    @Column(name = "shift_date")
    private Date shiftDate;
    @Column(name = "shift_start")
    private Date shiftStart;
    @Column(name = "shift_end")
    private Date shiftEnd;
    @Column(name = "state_holiday")
    private Boolean stateHoliday;
    @Column(name = "week_day")
    private String weekDay;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_shifts",
            joinColumns = @JoinColumn(name = "shift_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeesPresent;
}
