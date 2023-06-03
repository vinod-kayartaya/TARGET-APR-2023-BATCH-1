package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.HibernateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public class CreateCategory {
    public static void main(String[] args) {
        String categoryName = KeyboardUtil.getString("Enter category name: ");
        String description = KeyboardUtil.getString("Enter description: ");

        Category c1 = new Category();
        c1.setCategoryName(categoryName);
        c1.setDescription(description);

        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            try {
                session.persist(c1); // one or more DML statements
                tx.commit();
                log.trace("{} - saved", c1);
            }catch (Exception e){
                tx.rollback();
                log.warn("Couldn't save {}", c1, e);
            }

        }// session.close() called here

    }
}
