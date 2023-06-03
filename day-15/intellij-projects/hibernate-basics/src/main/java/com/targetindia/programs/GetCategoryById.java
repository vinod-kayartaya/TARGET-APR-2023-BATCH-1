package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class GetCategoryById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter category id to search: ");

        Configuration cfg = new Configuration();
        cfg.configure(); // looks for a file hibernate.cfg.xml in the classpath

        SessionFactory factory = cfg.buildSessionFactory(); // represents a DB
        Session session = factory.openSession(); // a DB connection is associated with this session
        Category c1 = session.get(Category.class, id);
        log.trace("category = {}", c1);
        session.close(); // closes the DB connection that it maintains
    }
}
