package top.king.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String remote = request.getRemoteAddr();
        System.out.println("远程连接：" + remote);
        if ("/k/user".equals(uri) || "/k/login".equals(uri)) {
            return true;
        } else {
            Object user = request.getSession().getAttribute(remote + "user");
            if (!ObjectUtils.isEmpty(user)) {
                return true;
            }
        }
        response.sendRedirect("/k/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("ModelAndView生成完成！");
    }
}
