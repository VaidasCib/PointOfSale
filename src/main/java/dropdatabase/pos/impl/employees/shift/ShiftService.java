package dropdatabase.pos.impl.employees.shift;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.employees.employee.Employee;
import dropdatabase.pos.impl.employees.employee.EmployeeRepository;
import dropdatabase.pos.impl.employees.shift.dto.ShiftDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftPostDto;
import dropdatabase.pos.impl.employees.shift.dto.ShiftPutDto;

import javax.inject.Inject;
import java.util.*;

public class ShiftService extends Service {
    @Inject
    private ShiftRepository shiftRepository;
    @Inject
    private EmployeeRepository employeeRepository;
//ENUM....
    public void post(ShiftPostDto shiftPostDto) {
        if (Arrays.stream(Shift.WeekDay.values()).noneMatch(day -> day.name().equals(shiftPostDto.getWeekDay()))) {
            throw new IllegalArgumentException("Week day is incorrect");
        }

        Shift shift = shiftRepository.newObject();
        getMapper().map(shiftPostDto, shift);

        List<Employee> employeesPresent = new ArrayList<>();
        shiftPostDto.getEmployeesPresent().forEach(employeeId -> {
            employeesPresent.add(employeeRepository.getObject(employeeId));
        });
        shift.setEmployeesPresent(employeesPresent);

        shiftRepository.save(shift);
    }

    public List<ShiftDto> getList(Date minDate, Date maxDate, Boolean stateHoliday, String weekDay) {
        return shiftRepository.getList(minDate, maxDate, stateHoliday, weekDay)
                .stream().map(shift -> getMapper().map(shift, ShiftDto.class)).toList();
    }

    public ShiftDto getById(UUID shiftId) {
        return getMapper().map(shiftRepository.getObject(shiftId), ShiftDto.class);
    }

    public void put(UUID shiftId, ShiftPutDto shiftPutDto) {
        if (Arrays.stream(Shift.WeekDay.values()).noneMatch(day -> day.name().equals(shiftPutDto.getWeekDay()))) {
            throw new IllegalArgumentException("Week day is incorrect");
        }

        Shift shift = shiftRepository.getObject(shiftId);
        getMapper().map(shiftPutDto, shift);
        shiftRepository.update(shift);
    }

    public void delete(UUID shiftId) {
        shiftRepository.delete(shiftId);
    }

    public void addEmployeeToShift(UUID shiftId, UUID employeeId) {
        Shift shift = shiftRepository.getObject(shiftId);
        shift.getEmployeesPresent().add(employeeRepository.getObject(employeeId));
        shiftRepository.update(shift);
    }

    public void removeEmployeeFromShift(UUID shiftId, UUID employeeId) {
        Shift shift = shiftRepository.getObject(shiftId);
        shift.getEmployeesPresent().remove(employeeRepository.getObject(employeeId));
        shiftRepository.update(shift);
    }
}
