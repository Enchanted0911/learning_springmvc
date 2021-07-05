package com.jun.handler;

import com.jun.exception.AgeException;
import com.jun.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 控制器增强 给控制器增加异常处理功能
 *                   在类的上面
 *                   必须让框架知道这个注解所在的包名，需要在springmvc配置文件声明组件扫描器
 *                   指定@ControllerAdvice所在包名
 * 异常处理逻辑 :
 *      1. 需要把异常记录下来, 记录到数据库, 日志文件。 记录日志发生的时间，哪个方法发生的，异常错误内容。
 *      2. 发送通知，把异常的信息通过邮件，短信等方式发送给相关工作人员
 *      3. 给用户友好的提示
 * @author Wu
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView, String, void对象类型返回值
     * @ExceptionHandler (异常的class)
     * @param e 表示controller中抛出的异常对象
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "name has to be \"vanessa\" ");
        modelAndView.addObject("ex", e);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView doAgeException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "age should be less than 80");
        modelAndView.addObject("ex", e);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }

    /**
     * 注解的value不写时就是处理其他类型异常
     * 这种没有value的注解的方法只能有一个
     */
    @ExceptionHandler
    public ModelAndView doOtherException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "something unexpected happened");
        modelAndView.addObject("ex", e);
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }
}
