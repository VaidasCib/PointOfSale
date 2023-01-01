package dropdatabase.pos.impl.arrangement.timeslots.dto;
import dropdatabase.pos.impl.arrangement.services.Services;

import dropdatabase.pos.impl.employees.employee.Employee;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class TimeslotDto {
    private UUID id;
    private String status;
    private Date slot_from;
    private Date slot_to;
    private String location;
    private List<Employee> employeesPresent;
    private Services services;
}

