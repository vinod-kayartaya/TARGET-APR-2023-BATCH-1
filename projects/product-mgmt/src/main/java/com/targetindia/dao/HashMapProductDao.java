package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.*;

public class HashMapProductDao implements ProductDao {
    // we may use a HashMap to store all product details, that can be identified using their respective ids
    private Map<Integer, Product> map = new HashMap<>();

    public HashMapProductDao() {
        Product p = new Product();
        p.setId(12);
        p.setCategory("Beverage");
        p.setName("Diet Coke");
        p.setUnitPrice(180.0);
        p.setQuantityPerUnit("Pack of 6 cans");
        p.setUnitsInStock(50);
        map.put(p.getId(), p);

        p = new Product();
        p.setId(67);
        p.setCategory("Condiments");
        p.setName("Yippie Noodles");
        p.setUnitPrice(65.0);
        p.setQuantityPerUnit("Pack of 4");
        p.setUnitsInStock(14);
        map.put(p.getId(), p);

        p = new Product();
        p.setId(18);
        p.setCategory("Beverage");
        p.setName("Badaam Milk");
        p.setUnitPrice(250.0);
        p.setQuantityPerUnit("6 tetra packs");
        p.setUnitsInStock(35);
        map.put(p.getId(), p);
    }

    public List<Product> getAllProducts() throws DaoException {
        List<Product> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return list;
    }

    public Product getProductById(int id) throws DaoException {
        return map.get(id);
    }

    @Override
    public void updateProduct(Product p) throws DaoException {

    }

    @Override
    public void deleteProduct(int id) throws DaoException {

    }

    public List<Product> getProductsByCategory(String category) throws DaoException {
        // this is how it was done prior to Java 1.8 Streams
        // WE SHALL UPDATE THIS LATER ONCE WE LEARN ABOUT STREAMS
        List<Product> list = new ArrayList<>();
        for (Product p : map.values()) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                list.add(p);
            }
        }
        return list;
    }

    public List<Product> getProductsByName(String name) throws DaoException {
        // TODO: Search products having the given 'name' in their product-name (partial match is enough)
        return null;
    }

    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException {
        // TODO: Search products having price between 'min' and 'max' and return the same
        return null;
    }

    public void addProduct(Product p) throws DaoException {
        map.put(p.getId(), p);
    }

}
