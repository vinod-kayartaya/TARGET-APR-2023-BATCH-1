package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateProductPrice {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter product id to search: ");
        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            Product p = em.find(Product.class, id);
            // a new entity object (i.e, p) is kept in the entity-manager cache
            // any entity objects in the entity-manager cache is called "persistent" object

            // for example,
            // Product p1 = new Product();
            // p1 is in the JVM, but not part of entity-manager cache
            // such objects are called "transient" objects


            if(p==null){
                System.out.printf("No product found for id %d%n", id);
                return;
            }

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                System.out.printf("Name : %s%n", p.getProductName());
                System.out.printf("Price: %.2f%n", p.getUnitPrice());
                double newPrice = KeyboardUtil.getDouble("Enter new price: ");
                p.setUnitPrice(newPrice); // p's status is now changed to 'dirty', only if
                // newPrice is different from its current value (i.e, p.getUnitPrice()) and
                // if it is a "persistent" object

                // whenever a "persistent" object's state changes, it's status is turned to 'dirty'
                tx.commit(); // SQL UPDATE commands are executed for every 'dirty' entities
                System.out.printf("Product price updated to %.2f%n", newPrice);
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        } // em.close() called
    }
}
