package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


@Slf4j
public class ProductDaoDemos {
    static ProductDao dao;

    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            dao = ctx.getBean(ProductDao.class);
            demo11();
        }// ctx.close() called here automatically
    }

    private static void demo11() {
        int productId = 102;
        dao.delete(productId);
        log.trace("Product with id {} deleted successfully!", productId);
    }

    private static void demo10() {
        Product p = dao.findById(201);
        p.setUnitPrice(35);
        p.setUnitsOnOrder(4);
        p.setUnitsInStock(24);
        dao.update(p);
        log.trace("product data updated successfully!");
    }

    private static void demo9() {
        Product p = new Product();
        p.setProductId(201);
        p.setProductName("Badam milk");
        p.setSupplierId(1);
        p.setCategoryId(1);
        p.setQuantityPerUnit("175ml bottle x 6");
        p.setUnitPrice(2.18);
        p.setDiscontinued(0);
        p.setReorderLevel(10);
        p.setUnitsInStock(28);
        p.setUnitsOnOrder(0);

        dao.create(p);
        log.trace("new product saved");

    }

    private static void demo8() {
        List<Product> list = dao.findByNamePattern("CHO");
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo7() {
        List<Product> list = dao.findBySupplier(1);
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo6() {
        List<Product> list = dao.findByCategory(1);
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo5() {
        List<Product> list = dao.findByPriceRange(50, 500);
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo4() {
        List<Product> list = dao.findAllOutOfStockProducts();
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo3() {
        List<Product> list = dao.findAllDiscontinuedProducts();
        list.stream().map(Product::toString).forEach(log::trace);
    }

    private static void demo2() {
        List<Product> list = dao.findAll();
        log.trace("there are {} products", list.size());
    }

    private static void demo1() {
        Product p = dao.findById(34);
        log.trace("p={}", p);
    }
}
