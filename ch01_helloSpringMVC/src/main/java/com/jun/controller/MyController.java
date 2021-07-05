package com.jun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这个注解和spring中 Component Service 注解类似
 * 都是创建对象的
 * @author Wu
 */
@Controller
public class MyController {
    /**
     * springmvc使用方法来处理用户提交的请求
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     * 准备使用doSome方法处理some.do请求
     * @RequestMapping : 请求映射，把一个请求地址和一个方法绑定在一起。一个请求指定一个方法处理
     *                  属性 1. value 是一个String数组， 可以包含多个uri，表示请求的uri地址(some.do) value的值唯一 使用时推荐地址以 "/" 开头 (暂时不懂)
     *                  被这个注解的方法叫做处理器方法或者控制器方法
     *                  被这个注解的方法可以处理请求 类似doGet 和 doPost
     * @return 表示处理结果 包括数据和视图两部分
     */
    @RequestMapping("/some.do")
    public ModelAndView doSome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc");
        modelAndView.addObject("fun", "执行doSome方法");
        // 框架对视图的forward操作, request.getRequestDispather("/show.jsp").forward(..);
        //modelAndView.setViewName("/WEB-INF/protect/show.jsp");
        //配置了视图解析器后， 使用逻辑名称指定视图
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
