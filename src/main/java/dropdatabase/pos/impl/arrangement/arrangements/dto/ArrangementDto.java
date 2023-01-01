package dropdatabase.pos.impl.arrangement.arrangements.dto;

import dropdatabase.pos.impl.arrangement.timeslots.Timeslot;
import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.employees.employee.Employee;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ArrangementDto {

    private UUID id;
    private List<Employee> employeesPresent;

    ///private List<Discount> discount;

    ///private Payment payment;

    private User user;

    private List<Timeslot> timeslotsPresent;

    private Double tips;

    private String specifications;
}
