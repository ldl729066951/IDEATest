package com.castor.base.servlet;

import com.castor.base.util.HttpUtil;
import com.castor.web.bean.ServiceAccessLog;
import com.castor.web.service.ServiceAccessLogService;

import javax.annotation.Resource;
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

    @Resource
    private ServiceAccessLogService service;

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

        //TODO googel event bus 异步处理
        String ip = HttpUtil.getIpAddress(request);
        String host = request.getRemoteHost();
        int port = request.getServerPort();
        String method = request.getMethod();
        String path = request.getRequestURI();
        int status = response.getStatus();
        Date end = new Date();
        long responseTime = end.getTime() - start.getTime();
        ServiceAccessLog bean = new ServiceAccessLog();
        bean.setIp(ip);
        bean.setHost(host);
        bean.setCreateAt(start);
        bean.setMethod(method);
        bean.setPort(port+"");
        bean.setPath(path);
        bean.setResponseStatus(status);
        bean.setResponseTime((int)responseTime);
        service.save(bean);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
