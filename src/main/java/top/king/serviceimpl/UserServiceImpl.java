package top.king.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import top.king.mapper.UserMapper;
import top.king.model.User;
import top.king.service.UserService;

import java.util.List;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean verifyUser(User user) {
        return userMapper.verifyUser(user) > 0;
    }

    @Override
    public List<User> selectUsers() {
        List<User> users = null;
        try {
            users = userMapper.selectUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        try {
            userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) {
        try {
            userMapper.inserUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String primaryKey) {
        try {
            userMapper.deleteUser(primaryKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
