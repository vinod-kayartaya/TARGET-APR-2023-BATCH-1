package com.targetindia.programs;

import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class GetSupplierById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter supplier id to search: ");
        Supplier s = null;
        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            s = em.find(Supplier.class, id);
            if(s==null){
                log.warn("No supplier found for id {}", id);
                return;
            }

        log.trace("Company name = {}", s.getCompanyName());
        log.trace("Contact person = {}", s.getContactName());
        log.trace("City = {}", s.getAddress().getCity());
        log.trace("Country = {}", s.getAddress().getCountry());
        log.trace("Products supplied: {}",
                s.getProducts()
                        .stream()
                        .map(p->p.getProductName())
                        .collect(Collectors.toList())
                );

        } // em.close() --> connection is closed
    }
}
