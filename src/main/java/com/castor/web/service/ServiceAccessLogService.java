package com.castor.web.service;

import com.castor.web.bean.ServiceAccessLog;
import com.castor.web.dao.ServiceAccessLogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceAccessLogService {

    @Resource
    private ServiceAccessLogRepository repository;

    public void save(ServiceAccessLog bean) {
        repository.save(bean);
    }

}
