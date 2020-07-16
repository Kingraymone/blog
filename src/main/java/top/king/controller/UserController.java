package top.king.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.king.model.User;
import top.king.serviceimpl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public void initValue(WebDataBinder webDataBinder) {
        System.out.println("user 方法执行！");
    }

    @InitBinder
    public void blankValue(WebDataBinder webDataBinder) {
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
        mav.setViewName("ok");
        mav.addObject("message", "just have a little faith");
        return mav;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView king(User user, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        if (userService.verifyUser(user)) {
            // session生成
            HttpSession session = request.getSession(true);
            String remote = request.getRemoteAddr();
            session.setAttribute(remote + "user", user);
            // cookie生成
            if (!ObjectUtils.isEmpty(user.getRemember())) {
                response.addCookie(new Cookie("username", user.getUsername()));
                response.addCookie(new Cookie("password", user.getPassword()));
            }
            System.out.println("生成sessionId：" + session.getId());
            mav.setViewName("main");
        } else {
            mav.setViewName("ok");
            mav.addObject("message", "用户密码错误！");
        }
        return mav;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "logout";
    }
}
