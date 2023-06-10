package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringContainerDemo2 {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        ) {
            log.trace("AnnotationConfigApplicationContext object created successfully");
            ProductDao dao;

            dao = ctx.getBean("dao1", ProductDao.class);
            log.trace("dao is an instanceof '{}' class", dao.getClass().getName());
            log.trace("product name for id 1 is '{}'", dao.getProductName(1));

            dao = ctx.getBean("dao2", ProductDao.class);
            log.trace("dao is an instanceof '{}' class", dao.getClass().getName());
            log.trace("product name for id 1 is '{}'", dao.getProductName(1));
        } // ctx.close() called automatically here
    }
}
