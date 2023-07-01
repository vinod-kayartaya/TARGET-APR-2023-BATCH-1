package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringContainerDemo3 {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        ) {
            log.trace("AnnotationConfigApplicationContext object created successfully");
            ProductDao dao1 = ctx.getBean("jdbcDao", ProductDao.class); // get a reference to a new singleton bean
            ProductDao dao2 = ctx.getBean("jdbcDao", ProductDao.class); // get a reference to the same bean again

            log.trace("dao1==dao2 is {}", dao1 == dao2);

            ProductDao dao3 = ctx.getBean("dummyDao", ProductDao.class); // get a reference to newly constructed bean
            ProductDao dao4 = ctx.getBean("dummyDao", ProductDao.class); // get a reference to another newly constructed bean
            log.trace("dao3==dao4 is {}", dao3 == dao4);

        } // ctx.close() called automatically here
    }
}
