package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class DisplayProductCount {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            long pc = dao.count();
            log.debug("pc = {}", pc);
        } // ctx.close() called here automatically
    }
}
