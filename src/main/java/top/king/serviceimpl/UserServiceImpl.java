package top.king.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import top.king.mapper.UserMapper;
import top.king.model.User;
import top.king.service.UserService;

import java.util.List;

@Component
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void selectUsers() {
        List<User> users = userMapper.selectUsers();
        System.out.println(users);
    }
}
