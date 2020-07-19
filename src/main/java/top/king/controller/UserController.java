package top.king.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.king.model.User;
import top.king.serviceimpl.UserServiceImpl;


@RequestMapping("/user")
@Controller
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
    public void initValue(WebDataBinder webDataBinder) {
        System.out.println("user 方法执行！");
    }

    @InitBinder
    public void blankValue(WebDataBinder webDataBinder) {
        System.out.println("空@InitBinder方法执行!");
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("user");
        mav.addObject("user",userService.selectUsers());
        return mav;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addUser(User user) {
        userService.insertUser(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteUser(String primaryKey) {
        userService.deleteUser(primaryKey);
    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody  User user) {
        userService.updateUser(user);
    }

}
