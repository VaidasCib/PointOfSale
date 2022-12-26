package dropdatabase.pos.impl.employees.shift.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel
public class ShiftPutDto {
    private Date shiftDate;
    private Date shiftStart;
    private Date shiftEnd;
    private Boolean stateHoliday;
    @ApiModelProperty(dataType = "string", allowableValues = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday")
    private String weekDay;
}
