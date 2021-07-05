package com.jun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
     * 逐个接收请求参数 :
     *      要求 : 处理器方法的形参名和请求参数名必须一致
     *            同名的请求参数赋值给同名的形参
     * @return 表示处理结果 包括数据和视图两部分
     */
    @RequestMapping(value = "/some")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName", name);
        modelAndView.addObject("myAge", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
