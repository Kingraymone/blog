package com.king.mapper;

import com.king.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleMapper {
    List<Role> selectRoles();

    Role selectRoleById(Integer id);
}
