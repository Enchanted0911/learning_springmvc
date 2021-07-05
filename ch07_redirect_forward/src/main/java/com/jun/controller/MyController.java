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
public class MyController {
    /**
     * 处理器方法返回ModelAndView，实现显示转发forward
     * 语法 : setViewName("forward : 视图文件完整路径")
     * forward特点 不和视图解析器一同使用(无视视图解析器)
     * 所以当不需要视图解析器转发的时候用forward显示转发
     */
    @RequestMapping(value = "/doForward.do", method = RequestMethod.POST)
    public ModelAndView doSome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc");
        modelAndView.addObject("fun", "执行doForward方法");
        modelAndView.setViewName("forward:/WEB-INF/protect/show.jsp");
        return modelAndView;
    }


}
