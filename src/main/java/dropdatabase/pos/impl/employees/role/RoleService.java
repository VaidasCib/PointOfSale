package dropdatabase.pos.impl.employees.role;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.employees.role.dto.RoleDto;
import dropdatabase.pos.impl.employees.role.dto.RolePostDto;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class RoleService extends Service {
    @Inject
    private RoleRepository roleRepository;

    public List<RoleDto> getAll() {
        return roleRepository.getList().stream().map(role -> getMapper().map(role, RoleDto.class)).toList();
    }

    public void post(RolePostDto rolePostDto) {
        Role role = roleRepository.newObject();
        getMapper().map(rolePostDto, role);
        roleRepository.save(role);
    }

    public void put(UUID roleId, RolePostDto rolePostDto) {
        Role role = roleRepository.getObject(roleId);
        getMapper().map(rolePostDto, role);
        roleRepository.update(role);
    }

    public void delete(UUID roleId) {
        roleRepository.delete(roleId);
    }

}
