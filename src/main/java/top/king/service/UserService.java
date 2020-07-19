package top.king.service;

import top.king.model.User;

import java.util.List;

public interface UserService {
    public List<User> selectUsers();

    public void updateUser(User user);

    public void insertUser(User user);

    public void deleteUser(String primaryKey);

    public boolean verifyUser(User user);

}
