package dropdatabase.pos.impl.employees.shift.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@ApiModel
public class ShiftPostDto {
    private Date shiftDate;
    private Date shiftStart;
    private Date shiftEnd;
    private Boolean stateHoliday;
    @ApiModelProperty(dataType = "string", allowableValues = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday")
    private String weekDay;
    private List<UUID> employeesPresent;
}
