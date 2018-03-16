package com.castor.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SpringConfig {

    /**
     * 查看博客
     * http://412887952-qq-com.iteye.com/blog/2292727
     * http://412887952-qq-com.iteye.com/blog/2292728
     */


    @Value("${spring.datasource.type}")
    private String datasourceType;

    public String getDatasourceType() {
        return datasourceType;
    }
}