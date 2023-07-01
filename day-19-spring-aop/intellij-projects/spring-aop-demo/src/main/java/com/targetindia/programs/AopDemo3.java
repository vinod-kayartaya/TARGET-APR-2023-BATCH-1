package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AopDemo3 {
    public static void main(String[] args) {
        // TRY THIS PROGRAM BY STOPPING THE DB SERVER
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);

            try {
                Product p1 = dao.findById(12);
                log.trace("p1 = {}", p1);
            } catch (DaoException e) {
                // Although the actual implementation of "findById(..)" does not throw an
                // object of DaoException, the AOP proxy with the help of @AfterThrowing advice,
                // transforms any exception thrown into a DaoException for the pointcut:
                // execution(* com.tar*..*Dao.*(..))
                log.trace("There was an error: {}", e.getMessage());
            }
        }
    }
}
