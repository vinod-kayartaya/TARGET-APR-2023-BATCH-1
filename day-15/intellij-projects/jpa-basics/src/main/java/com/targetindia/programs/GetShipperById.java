package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetShipperById {
    public static void main(String[] args) {
        int shipperId = KeyboardUtil.getInt("Enter shipper id to search: ");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("h2-northwind");
        log.trace("factory is an instanceof '{}' type", factory.getClass().getName());
        EntityManager em = factory.createEntityManager();
        log.trace("em is an instanceof '{}' type", em.getClass().getName());
        Shipper shipper = em.find(Shipper.class, shipperId);
        log.trace("shipper details for id {} is {}", shipperId, shipper);
    }
}
