package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AopDemo2 {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            int id = KeyboardUtil.getInt("Enter product id to search: ");
            Product p1 = dao.findById(id);
            if(p1==null){
                System.out.printf("No product found with id %d%n", id);
                return;
            }

            String newName = KeyboardUtil.getString("Enter new name of the product: [%s] ".formatted(p1.getProductName()));
            if(newName.isBlank()){
                System.out.println("Operation cancelled");
                return;
            }

            p1.setProductName(newName);

            dao.update(p1);
        }
    }
}
