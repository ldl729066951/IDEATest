package com.castor.base.servlet;

import com.castor.base.event.CastorEventBus;
import com.castor.base.event.ServiceAccessEvent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 *
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * @version v.0.1
 */
@WebFilter(filterName = "myFitler", urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        Date start = new Date();
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        System.out.println("执行过滤操作"+request.getRequestURL());
        chain.doFilter(servletRequest, servletResponse);

        // googel event bus 异步处理记录用户行为
        CastorEventBus.getEventBus().post(ServiceAccessEvent.create(request, response, start));
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
