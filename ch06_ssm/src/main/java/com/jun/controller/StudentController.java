package com.jun.controller;

import com.jun.domain.Student;
import com.jun.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wu
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        String tips = "注册失败";
        if(service.addStudent(student) > 0) {
            tips = "学生 " + student.getName() + " 注册成功";
        }
        modelAndView.addObject("tips", tips);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent() {
        return service.findStudents();
    }
}
