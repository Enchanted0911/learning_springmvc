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


    @RequestMapping(value = "/returnString.do")
    public String doTwoOther(HttpServletRequest request, String name, Integer age) {
        String view = "show";
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);
        System.out.println("returnString, name = " + name + " age = " + age);
        // 框架对视图执行forward转发操作
        return view;
    }

    @RequestMapping(value = "/returnVoidAjax.do")
    public void doThreeOther(HttpServletResponse response, String name, Integer age) throws IOException {
        Student student = new Student(name, age);
        String json = "";
        ObjectMapper objectMapper = new ObjectMapper();
        json = objectMapper.writeValueAsString(student);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @ResponseBody : 作用是把处理器方法返回对象转化为Json后，通过HttpServletResponse输出给浏览器
     *                  位置 方法定义上面
     *框架转换json流程 :
     *              1. 框架会把返回Student类型调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite方法
     *                 检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据
     *              2. 框架会调用实现类的write方法, MappingJackson2HttpMessageConverter的write方法
     *                 把Student对象转为json，任何调用Jackson的ObjectMapper实现转为json
     *              3. 框架会调用@ResponseBody把2的结果输出到浏览器，ajax请求处理完成
     */
    @ResponseBody
    @RequestMapping(value = "/returnStudentJson.do")
    public Student doFourOther(String name, Integer age) {
        return new Student(name, age);
    }

    @ResponseBody
    @RequestMapping(value = "/returnStudentJsonArray.do")
    public List<Student> doFiveOther(String name, Integer age) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("vanessa", 18));
        students.add(new Student("Ives", 18));
        return students;
    }

    /**
     * 处理器方法返回值是String， 表示数据， 不是视图
     * 区分返回值String是数据还是视图， 看有无@ResponseBody注解
     * 如果有这个注解， 返回String就是数据，反之就是视图
     * 默认使用"text/plain;charset=iso-8859-1" 作为contentType, 导致中文有乱码
     * 解决方案 : 给RequestMapping 增加一个属性 produces，使用这个属性指定新的ContentType
     */
    @ResponseBody
    @RequestMapping(value = "/returnStringData.do", produces = "text/plain;charset=utf-8")
    public String doSixOther(String name, Integer age) {
        return "hello springmvc中文有没有乱码呢, 确实有, 已解决";
    }
}
