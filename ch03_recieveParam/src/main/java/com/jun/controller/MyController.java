package com.jun.controller;

import com.jun.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 逐个接收请求参数 :
     *      要求 : 处理器方法的形参名和请求参数名必须一致
     *            同名的请求参数赋值给同名的形参
     * @return 表示处理结果 包括数据和视图两部分
     */
    @RequestMapping(value = "/receiveProperty.do")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName", name);
        modelAndView.addObject("myAge", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 请求中参数名和方法的形参名不一样
     * @RequestParam  逐个接收请求参数中，解决请求中参数名和形参名不一致的问题
     *                  属性 1. value 请求中的参数名称
     *                      2. required 是一个boolean 默认为true 表示请求中必须包含此参数 否则报错400
     *                  位置 在处理器方法的形参定义前面
     */
    @RequestMapping(value = "/receiveParam.do")
    public ModelAndView doOther(@RequestParam(value = "rName", required = false) String name, @RequestParam(value = "rAge", required = false) Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName", name);
        modelAndView.addObject("myAge", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 处理器方法用对象来接收请求参数时，对象属性和请求参数名一致
     * 框架会自动创建对象，并且调用setter方法给对象属性赋值
     * @param student 接收请求参数的对象
     * @return 返回结果
     */
    @RequestMapping(value = "/receiveObject.do")
    public ModelAndView doAnOther(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName", student.getName());
        modelAndView.addObject("myAge", student.getAge());
        modelAndView.addObject("myStudent", student);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
