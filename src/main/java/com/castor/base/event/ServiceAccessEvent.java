package com.castor.base.event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ServiceAccessEvent {

    public static ServiceAccessEvent create(HttpServletRequest request, HttpServletResponse response, Date startAt){
        return new ServiceAccessEvent(request, response, startAt);
    }

    public ServiceAccessEvent(HttpServletRequest request, HttpServletResponse response, Date startAt) {
        this.request = request;
        this.response = response;
        this.startAt = startAt;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Date startAt;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }
}
