package com.king.mapper;

import com.king.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface UserMapper {
    List<User> selectUsers();
}
