package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductById {
    public static void main(String[] args) {

        int id = KeyboardUtil.getInt("Enter product id to search: ");
        Product pr = null;
        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            pr = em.find(Product.class, id);
            // when the products record is fetched from the DB,
            // corresponding categories record is also fetched using
            // a join column, because of @ManyToOne

            if(pr==null){
                log.warn("No product found for id {}", id);
                return;
            }
        } // em.close() called here, which closes the underlying DB connection

        log.trace("product name = {}", pr.getProductName());
        log.trace("unit price = {}", pr.getUnitPrice());
        log.trace("category = {}", pr.getCategory().getCategoryName());
        log.trace("description = {}", pr.getCategory().getDescription());
        log.trace("Supplied by {}", pr.getSupplier().getCompanyName());
        log.trace("Supplied from the city of {}, {}",
                pr.getSupplier().getAddress().getCity(),
                pr.getSupplier().getAddress().getCountry());
    }
}
