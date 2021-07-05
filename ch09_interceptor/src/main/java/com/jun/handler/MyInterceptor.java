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
    private long beginTime = 0;

    /**
     * 预处理方法
     * 特点 ：
     *      1. 在控制器方法之前先执行的，用户的请求首先到达此方法
     *      2. 在这个方法中可以获取请求的信息，验证请求是否符合要求
     *         可以验证用户是否登录，验证用户是否有权限访问某个链接地址
     *         如果验证失败可以截断请求，请求不能被处理
     *         如果验证成功，可以放行请求，此时控制器方法才能执行
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 被拦截的控制器对象
     * @return 布尔值 true放行 false 拦截
     * @throws Exception 可能抛出异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        beginTime = System.currentTimeMillis();
        System.out.println("---------preHandle-------------");
        return true;
    }

    /**
     * 后处理方法
     * 特点 ：
     *      1. 在处理器方法之后执行的
     *      2. 能够获取到处理器方法的返回值ModelAndView，可以对其进行修改，并影响到最后的执行结果
     *      3. 主要是对原来的结果进行二次修正
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 被拦截的处理器对象
     * @param modelAndView 处理器方法的返回值
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("---------postHandle-------------");
        if (modelAndView != null) {
            modelAndView.addObject("myDate", new Date());
            modelAndView.setViewName("other");
        }
    }

    /**
     * 最后执行的方法
     * 特点 :
     *      1. 在请求处理完成后执行的， 框架中规定是当你的视图处理完成后，对视图执行了forward。就认为请求处理完成
     *      2. 一般做资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收
     * @param handler 被拦截的处理器对象
     * @param ex 程序中发生的异常
     * @throws Exception 该方法可能抛出的异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println("---------afterHandle-------------");
        System.out.println(endTime - beginTime);
    }
}
