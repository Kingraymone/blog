package top.king.mapper;

import top.king.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();

    void deleteUser(String primaryKey);

    void inserUser(User user);

    void updateUser(User user);

    Integer verifyUser(User user);
}
