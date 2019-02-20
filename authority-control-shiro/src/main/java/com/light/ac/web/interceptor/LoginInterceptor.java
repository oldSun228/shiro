package com.light.ac.web.interceptor;

import com.light.ac.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {

        //获取本来要访问的网址url
        String requestUrl = request.getScheme() //当前链接使用的协议
                +"://" + request.getServerName()//服务器地址
                + ":" + request.getServerPort() //端口号
                + request.getContextPath() //应用名称，如果应用名称为
                + request.getServletPath(); //请求的相对url
//                + "?" + request.getQueryString(); //请求参数
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + requestUrl);

        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();

        if (user != null) {
            return true;
        }

        response.sendRedirect("/index.jsp");

        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

}
