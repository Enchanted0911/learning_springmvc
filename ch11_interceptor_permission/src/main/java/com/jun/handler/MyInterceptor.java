package com.jun.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Wu
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------111---preHandle-------------");
        Object name = request.getSession().getAttribute("name");
        String loginName = "", realName = "vanessa";
        if (name != null) {
            loginName = (String) name;
        }
        if (!realName.equals(loginName)) {
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
