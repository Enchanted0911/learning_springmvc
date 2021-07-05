package com.jun.controller;

import com.jun.exception.AgeException;
import com.jun.exception.MyUserException;
import com.jun.exception.NameException;
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
    @RequestMapping(value = "/some.do", method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        int wrongAge = 80;
        String yesName = "vanessa";
        ModelAndView modelAndView = new ModelAndView();
        if (!yesName.equals(name)) {
            throw new NameException("不是这个名字哦");
        }
        if (age == null || age > wrongAge) {
            throw new AgeException("年龄不太合适吧");
        }
        modelAndView.addObject("myName", name);
        modelAndView.addObject("myAge", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
