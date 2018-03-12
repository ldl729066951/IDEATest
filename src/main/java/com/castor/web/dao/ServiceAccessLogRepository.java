package com.castor.web.dao;

import com.castor.web.bean.ServiceAccessLog;
import org.springframework.data.repository.CrudRepository;

public interface ServiceAccessLogRepository extends CrudRepository<ServiceAccessLog, Long> {
}
