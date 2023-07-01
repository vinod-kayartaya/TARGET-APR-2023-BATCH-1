package com.targetindia.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static Session getSession(){
        Configuration cfg = new Configuration();
        cfg.configure(); // looks for a file hibernate.cfg.xml in the classpath

        SessionFactory factory = cfg.buildSessionFactory(); // represents a DB
        return factory.openSession(); // a DB connection is associated with this session
    }
}
