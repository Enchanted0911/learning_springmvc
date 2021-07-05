package com.jun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 这个注解和spring中 Component Service 注解类似
 * 都是创建对象的
 * @RequestMapping value : 所有请求地址的公共部分， 叫做模块名称
 *                 位置 : 放在类的上面
 * @author Wu
 */
@RequestMapping("/test")
@Controller
@SuppressWarnings("all")
public class MyController {
    /**
     * springmvc使用方法来处理用户提交的请求
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     * 准备使用doSome方法处理some.do请求
     * @RequestMapping : 请求映射，把一个请求地址和一个方法绑定在一起。一个请求指定一个方法处理
     *                  属性 1. value 是一个String数组， 可以包含多个uri，表示请求的uri地址(some.do) value的值唯一 使用时推荐地址以 "/" 开头 (暂时不懂)
     *                      被这个注解的方法叫做处理器方法或者控制器方法
     *                      被这个注解的方法可以处理请求 类似doGet 和 doPost
     *                      2. method 表示请求的方式。值是RequestMethod的枚举值  RequestMethod.GET .POST
     *                         如果不指定method请求方式无限制(根据jsp等文件指定请求方式)
     * @return 表示处理结果 包括数据和视图两部分
     */
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc" + request.getParameter("name"));
        modelAndView.addObject("fun", "执行doSome方法");
        /* 框架对视图的forward操作, request.getRequestDispather("/show.jsp").forward(..);
            modelAndView.setViewName("/WEB-INF/protect/show.jsp");
            配置了视图解析器后， 使用逻辑名称指定视图
        */
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
