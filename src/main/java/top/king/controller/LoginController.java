package top.king.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.king.model.User;
import top.king.service.FileResourceService;
import top.king.serviceimpl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/k")
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    FileResourceService fileResourceService;



    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("ok");
        mav.addObject("message", "just have a little faith");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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

    @RequestMapping("/model")
    public ModelAndView james(ModelAndView mav) {
        mav.setViewName("main");
        mav.addObject("fileNames", fileResourceService.searchFiles());
        return mav;
    }
}
