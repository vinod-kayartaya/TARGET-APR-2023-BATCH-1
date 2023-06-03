package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.HibernateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class GetCategoryById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter category id to search: ");

        Session session = HibernateUtil.getSession();
        log.trace("session is an instanceof {} type", session.getClass().getName());
        Category c1 = session.get(Category.class, id);
        log.trace("category name = {}", c1.getCategoryName());
        log.trace("description = {}", c1.getDescription());

        byte[] picture = c1.getPicture();
        if (picture != null) {
            String filename = c1.getCategoryName().toLowerCase() + ".jpg";
            try (FileOutputStream out = new FileOutputStream(filename)) {
                out.write(picture);
                log.trace("Category picture saved to file - {}", filename);
            } // out.close() called here
            catch (IOException e) {
                log.warn("error", e);
            }
        }
        else {
            log.trace("This category does not have a picture");
        }


        session.close(); // closes the DB connection that it maintains
    }
}
