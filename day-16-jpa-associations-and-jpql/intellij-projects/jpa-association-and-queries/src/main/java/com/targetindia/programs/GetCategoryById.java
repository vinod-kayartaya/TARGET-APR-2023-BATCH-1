package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetCategoryById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter category id to search: ");
        Category cat = null;


        try (EntityManager em = JpaUtil.createEntityManager()) {
            cat = em.find(Category.class, id);
            if (cat == null) {
                log.warn("No category for id {}", id);
                return;
            }

            log.trace("Category name = {}", cat.getCategoryName());
            log.trace("Description = {}", cat.getDescription());
            log.trace("Products in this category are: ");
            cat.getProducts() // if (fetch=FetchType.LAZY) then there is an error, since DB connection is closed
                    .forEach(p -> log.trace("Product name = {}", p.getProductName()));
        } // em.close() called here, and DB connection gets closed as well
    }
}
