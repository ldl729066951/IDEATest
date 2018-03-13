package com.castor.base.event;

import com.castor.base.util.HttpUtil;
import com.castor.web.bean.ServiceAccessLog;
import com.castor.web.service.ServiceAccessLogService;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class EventsHandler {

    @Resource
    private ServiceAccessLogService service;

    public EventsHandler(){
        CastorEventBus.getEventBus().register(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void demo(DemoEvent event){
        System.out.println(Thread.currentThread().getName()+"aaaa");
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void serviceAccesss(ServiceAccessEvent event){
        HttpServletRequest request = event.getRequest();
        HttpServletResponse response = event.getResponse();
        Date startAt = event.getStartAt();

        String ip = HttpUtil.getIpAddress(request);
        String host = request.getRemoteHost();
        int port = request.getServerPort();
        String method = request.getMethod();
        String path = request.getRequestURI();
        int status = response.getStatus();
        Date endAt = new Date();
        long responseTime = endAt.getTime() - startAt.getTime();
        ServiceAccessLog bean = new ServiceAccessLog();
        bean.setIp(ip);
        bean.setHost(host);
        bean.setCreateAt(startAt);
        bean.setMethod(method);
        bean.setPort(port+"");
        bean.setPath(path);
        bean.setResponseStatus(status);
        bean.setResponseTime((int)responseTime);
        service.save(bean);

    }


}
