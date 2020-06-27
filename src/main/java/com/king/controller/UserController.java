package com.king.controller;

import com.king.model.User;
import com.king.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    public String test() {
        userService.selectUsers();
        return "ok";
    }
}
