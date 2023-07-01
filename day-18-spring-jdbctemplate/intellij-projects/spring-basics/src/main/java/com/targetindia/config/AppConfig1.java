package com.targetindia.config;

import com.targetindia.dao.JdbcProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc-info.properties") // spring loads all the key/value pairs from the file
public class AppConfig1 {

    @Bean
    public JdbcProductDao jpd(){
        return new JdbcProductDao();
    }
}
