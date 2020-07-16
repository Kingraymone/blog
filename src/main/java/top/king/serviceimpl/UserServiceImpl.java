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
    public void selectUsers() {
        List<User> users = userMapper.selectUsers();
        System.out.println(users);
    }

    public boolean verifyUser(User user) {
        return userMapper.verifyUser(user) > 0;
    }
}
