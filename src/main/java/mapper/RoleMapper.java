package mapper;

import model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> selectRoles();

    Role selectRoleById(Integer id);
}
