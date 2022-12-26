package dropdatabase.pos.impl.employees.employee;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.core.user.UserRepository;
import dropdatabase.pos.impl.employees.employee.dto.EmployeeDto;
import dropdatabase.pos.impl.employees.employee.dto.EmployeePostDto;
import dropdatabase.pos.impl.employees.role.RoleRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class EmployeeService extends Service {
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private RoleRepository roleRepository;

    public void post(EmployeePostDto employeePostDto) {
        Employee employee = employeeRepository.newObject();
        getMapper().map(employeePostDto, employee);
        employee.setUser(userRepository.getObject(employeePostDto.getUserId()));
        employee.setRole(roleRepository.getObject(employeePostDto.getRoleId()));
        employeeRepository.save(employee);
    }

    public List<EmployeeDto> getList(BigDecimal minSalary, BigDecimal maxSalary, UUID roleId, Boolean onHoliday) {
        return employeeRepository.getList(minSalary, maxSalary, roleId, onHoliday)
                .stream().map(employee -> getMapper().map(employee, EmployeeDto.class)).toList();
    }

    public EmployeeDto getById(UUID employeeId) {
        return getMapper().map(employeeRepository.getObject(employeeId), EmployeeDto.class);
    }

    public void put(UUID employeeId, EmployeePostDto employeePostDto) {
        Employee employee = employeeRepository.getObject(employeeId);
        getMapper().map(employeePostDto, employee);
        employeeRepository.update(employee);
    }

}
