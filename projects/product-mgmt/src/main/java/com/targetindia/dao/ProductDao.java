package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.List;

public interface ProductDao {

    // CRUD operations
    public void addProduct(Product p) throws DaoException;
    public Product getProductById(int id) throws DaoException;
    public void updateProduct(Product p) throws DaoException;
    public void deleteProduct(int id) throws DaoException;

    // QUERY operations
    public List<Product> getAllProducts() throws DaoException;
    public List<Product> getProductsByCategory(String category) throws DaoException;
    public List<Product> getProductsByName(String name) throws DaoException;
    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException;
}
