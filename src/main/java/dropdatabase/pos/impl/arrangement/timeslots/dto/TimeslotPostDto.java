package dropdatabase.pos.impl.arrangement.timeslots.dto;

import dropdatabase.pos.impl.arrangement.services.Services;
import dropdatabase.pos.impl.employees.employee.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel
public class TimeslotPostDto {
    @ApiModelProperty(dataType = "string", allowableValues = "Open, Booked, In_progress, Completed, Cancelled")
    private String status;
    private Date slot_from;
    private Date slot_to;
    private String location;
    private List<Employee> employeesPresent;
    private Services services;
}
