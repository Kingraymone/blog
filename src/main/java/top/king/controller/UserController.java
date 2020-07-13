package top.king.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.king.serviceimpl.UserServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/k")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @ModelAttribute("test")
    public String test() {
        return "abcd";
    }

    @ModelAttribute
    public String king() {
        System.out.println("方法ModelAttribute！");
        return "efgh";
    }
    @InitBinder("user")
    public void initValue(WebDataBinder webDataBinder){
        System.out.println("user 方法执行！");
    }
    @InitBinder
    public void blankValue(WebDataBinder webDataBinder){
        System.out.println("空@InitBinder方法执行!");
    }

    @RequestMapping("/model")
    public void james(HttpServletResponse response) {
        try {
            response.getWriter().write("跳过返回值处理！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/model2")
    @ModelAttribute("test2")
    public String test2() {
        System.out.println("同时注解在方法上！");
        return "both annotation！";
    }

    @RequestMapping("/login")
    public ModelAndView test(ModelAndView mav) {
        //userService.selectUsers();
        mav.setViewName("ok");
        mav.addObject("message", "just have a little faith");
        return mav;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String king( String username,   String password) {
        if ("king".equals(username) && "1234".equals(password)) {
            return "login success！";
        } else {
            return "login fail！";
        }
    }
}
