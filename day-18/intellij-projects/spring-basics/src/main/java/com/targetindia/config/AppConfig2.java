package com.targetindia.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = {"com.targetindia.dao"})
// The above annotation instructs spring container to go and look for any class that is annotated with
// @Component, @Configuration, @Service, @Repository, @Controller, @RestController and if found,
// create an object of that class, load into the spring container
public class AppConfig2 {

    // since Spring is supposed to call this method, it is Spring's obligation to pass
    // the required parameters (which we call as DEPENDENCIES). And to help Spring, we
    // use the @Value() annotation, which passes the values read from the properties file
    @Bean(name="dataSource")
    public BasicDataSource bds(
            @Value("${jdbc.connection.driverClassName}") String driverClassName,
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.user}") String user,
            @Value("${jdbc.connection.password}") String password) {

        log.trace("bds() is called with arguments {}, {}, {}, {}",
                driverClassName, url, user, password);
        BasicDataSource ds = new BasicDataSource();
        ds.setInitialSize(5);
        ds.setMaxTotal(50);
        ds.setMaxIdle(10);
        ds.setMaxWaitMillis(50);
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }
}
