package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AopDemo4 {
    public static void main(String[] args) {
        // TRY THIS PROGRAM BY STOPPING THE DB SERVER
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);

            double min = 50;
            double max = 500;
            List<Product> list = dao.findByPriceRange(min, max);
            log.trace("there are {} products between ${} and ${} unit price", list.size(), min, max);

            min = 500;
            max = 50;
            list = dao.findByPriceRange(min, max);
            log.trace("there are {} products between ${} and ${} unit price", list.size(), min, max);
        }
    }
}
