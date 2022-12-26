package dropdatabase.pos.impl.employees.employee.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class EmployeePostDto {
    private UUID userId;
    private UUID roleId;
    private BigDecimal salary;
    private Boolean onHoliday;
}
