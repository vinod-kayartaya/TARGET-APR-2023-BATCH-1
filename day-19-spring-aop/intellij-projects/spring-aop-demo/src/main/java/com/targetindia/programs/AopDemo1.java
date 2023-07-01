package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AopDemo1 {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof {} class", dao.getClass().getName());
            int id = 54;
            Product p1 = dao.findById(id);
            log.trace("p1 = {}", p1);

            List<Product> list = dao.findAll();
            log.trace("There are {} products", list.size());

            list = dao.findAllDiscontinuedProducts();
            log.trace("{} products have been discontinued", list.size());

            list = dao.findAllOutOfStockProducts();
            log.trace("{} products are out of stock!", list.size());

            list = dao.findByCategory(3);
            log.trace("There are {} products in category id 3", list.size());
        }
    }
}
