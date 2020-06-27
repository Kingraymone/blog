package com.king.serviceimpl;

import com.king.mapper.UserMapper;
import com.king.model.User;
import com.king.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void selectUsers() {
        List<User> users = userMapper.selectUsers();
        System.out.println(users);
    }
}
