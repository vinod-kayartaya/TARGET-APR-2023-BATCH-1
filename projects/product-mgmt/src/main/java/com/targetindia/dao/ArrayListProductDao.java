package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ArrayListProductDao implements ProductDao{

    List<Product> products;

    public ArrayListProductDao() {
        products = new ArrayList<>();
        Product p = new Product();
        p.setId(90);
        p.setCategory("Computer accessories");
        p.setName("TVSE Keyboard");
        p.setUnitsInStock(4);
        p.setUnitPrice(1200.0);
        p.setQuantityPerUnit("1 keyboard in 1 box");
        products.add(p);
    }

    @Override
    public void addProduct(Product p) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public Product getProductById(int id) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public void updateProduct(Product p) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        return this.products;
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public List<Product> getProductsByName(String name) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException {
        throw new DaoException("Method not implemented yet!");
    }
}
