package com.targetindia.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = {"com.targetindia.dao"})
// looks for classes decorated with:
// @Component, @Service, @Repository, @Controller, @RestController, @Configuration
public class AppConfig1 {

    @Bean
    public JdbcTemplate template(DataSource ds) { // Dependency injection takes place here
        log.trace("AppConfig1.template() called");
        log.trace("ds is an instanceof {}", ds.getClass().getName());
        return new JdbcTemplate(ds); // wiring "ds" with JdbcTemplate object manually (manual wiring)
    }

    @Bean(name = "dataSource")
    public BasicDataSource bds(
            @Value("${jdbc.connection.driverClassName}") String driverClassName,
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.user}") String user,
            @Value("${jdbc.connection.password}") String password) {
        log.trace("AppConfig1.bds() called");

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
