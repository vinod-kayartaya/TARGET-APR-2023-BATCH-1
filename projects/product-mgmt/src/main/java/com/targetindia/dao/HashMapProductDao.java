package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.*;

public class HashMapProductDao {
    // we may use a HashMap to store all product details, that can be identified using their respective ids
    private Map<Integer, Product> map = new HashMap<>();

    public HashMapProductDao() {
        Product p = new Product();
        p.setId(12);
        p.setCategory("Beverage");
        p.setName("Diet Coke");
        p.setUnitPrice(180);
        p.setQuantityPerUnit("Pack of 6 cans");
        p.setUnitsInStock(50);
        map.put(p.getId(), p);

        p = new Product();
        p.setId(67);
        p.setCategory("Condiments");
        p.setName("Yippie Noodles");
        p.setUnitPrice(65);
        p.setQuantityPerUnit("Pack of 4");
        p.setUnitsInStock(14);
        map.put(p.getId(), p);

        p = new Product();
        p.setId(18);
        p.setCategory("Beverage");
        p.setName("Badaam Milk");
        p.setUnitPrice(250);
        p.setQuantityPerUnit("6 tetra packs");
        p.setUnitsInStock(35);
        map.put(p.getId(), p);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return list;
    }
}
