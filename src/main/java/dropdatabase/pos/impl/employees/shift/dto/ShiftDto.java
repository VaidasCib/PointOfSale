package dropdatabase.pos.impl.employees.shift.dto;

import dropdatabase.pos.impl.employees.employee.dto.EmployeeDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ShiftDto {
    private UUID id;
    private Date shiftDate;
    private Date shiftStart;
    private Date shiftEnd;
    private Boolean stateHoliday;
    private String weekDay;
    private List<EmployeeDto> employeesPresent;
}
