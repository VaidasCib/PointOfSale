package dropdatabase.pos.impl.employees.employee.dto;

import dropdatabase.pos.impl.core.user.User;
import dropdatabase.pos.impl.employees.role.Role;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID id;
    private User user;
    private Role role;
    private BigDecimal salary;
    private Boolean onHoliday;
}
