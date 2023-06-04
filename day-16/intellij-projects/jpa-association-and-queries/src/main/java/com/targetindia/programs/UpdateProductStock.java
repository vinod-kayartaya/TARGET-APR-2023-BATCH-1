package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateProductStock {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter product id to search: ");

        Product p = new Product();
        // p is called a "transient" object (from JPA's perspective)

        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            p = em.find(Product.class, id);
            // 'p' now is a persistent object; it is now in the entity-manager cache
            if (p == null) {
                System.out.printf("No product found for id %d%n", id);
                return;
            }
        }// em.close() called, and "p" continues to live in the JVM
        // now "p" is called a "detached" object (from JPA's perspective)
        // changes done on "p" will not be managed by JPA

        System.out.printf("Name           : %s%n", p.getProductName());
        System.out.printf("Price          : %.2f%n", p.getUnitPrice());
        System.out.printf("Units in stock : %d%n", p.getUnitsInStock());
        int newStockValue = KeyboardUtil.getInt("Enter new value for units in stock: ");
        p.setUnitsInStock(newStockValue);

        // let's now save it to the db table, using a new entity manager
        try(EntityManager em = JpaUtil.createEntityManager()){
            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                em.merge(p); // makes the "detached" p as "persistent" again
                tx.commit();
                // tx.commit() now first executes a select statement querying for product with p.productId
                // i.e, SELECT * FROM PRODUCTS WHERE PRODUCT_ID = {p.getProductId()}
                // Checks if the values coming from the table are same/different from the values in "p"
                // if different, execute an SQL UPDATE command sending the values in "p"
                // else no action
            }
            catch (Exception e){
                tx.rollback();
                throw e;
            }
        }
    }
}
