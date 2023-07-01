package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.HibernateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class UpdateCategoryPicture {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter category id to search: ");

        try (
                Session session = HibernateUtil.getSession();
        ) {
            Category c1 = session.get(Category.class, id);
            if (c1 == null) {
                log.error("No category record found for id {}", id);
                return;
            }

            String pictureFilename = KeyboardUtil.getString("Enter picture filename: ");
            try (
                    FileInputStream file = new FileInputStream(pictureFilename)
            ) {
                c1.setPicture(file.readAllBytes());
                session.beginTransaction().commit();
                log.trace("Category picture updated to the db!");
            }
            catch(IOException e){
                log.warn("Unable to open the file {}", pictureFilename, e);
            }
        } // session.close() is called here
    }
}
