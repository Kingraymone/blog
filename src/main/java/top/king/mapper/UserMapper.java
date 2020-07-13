package top.king.mapper;

import top.king.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();
}
