package top.king.mapper;

import top.king.model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> selectRoles();

    Role selectRoleById(Integer id);
}
