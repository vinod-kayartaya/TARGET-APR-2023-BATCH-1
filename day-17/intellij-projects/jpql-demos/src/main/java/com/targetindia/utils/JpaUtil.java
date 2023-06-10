package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil() {
    }

    public static EntityManager createEntityManager(){
        return Persistence
                .createEntityManagerFactory("h2-northwind")
                .createEntityManager();
    }
}
