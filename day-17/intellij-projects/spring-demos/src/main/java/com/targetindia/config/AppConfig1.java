package com.targetindia.config;

import com.targetindia.dao.DummyProductDao;
import com.targetindia.dao.JdbcProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class AppConfig1 {

    public AppConfig1() {
        log.trace("AppConfig1 constructor called");
    }

    @Bean(name = {"dao1", "jdbcDao"})
    @Lazy // applies only for singleton beans
    public JdbcProductDao jdbcDao() {
        log.trace("creating and returning an object of JdbcProductDao");
        return new JdbcProductDao();
    }

    @Bean({"dao2", "dummyDao"})
    @Scope("prototype")
    public DummyProductDao dummyDao() {
        log.trace("creating and returning an object of DummyProductDao");
        return new DummyProductDao();
    }
}
