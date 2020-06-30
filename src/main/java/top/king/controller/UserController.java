package top.king.controller;

import org.springframework.web.servlet.ModelAndView;
import top.king.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/k")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public ModelAndView test(ModelAndView mav) {
        userService.selectUsers();
        mav.setViewName("ok");
        mav.addObject("message","just have a little faith");
        return mav;
    }
}
