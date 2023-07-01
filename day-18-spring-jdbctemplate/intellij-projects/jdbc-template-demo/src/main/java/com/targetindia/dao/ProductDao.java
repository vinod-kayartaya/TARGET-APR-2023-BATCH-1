package com.targetindia.dao;

import com.targetindia.entity.Product;

import java.util.List;

public interface ProductDao {
    // CRUD operations
    public void create(Product product) throws DaoException;

    public Product findById(int productId) throws DaoException;

    public void update(Product product) throws DaoException;

    public void delete(int productId) throws DaoException;

    // Query operations
    public List<Product> findAll() throws DaoException;

    public List<Product> findAllDiscontinuedProducts() throws DaoException;

    public List<Product> findAllOutOfStockProducts() throws DaoException;

    public List<Product> findByPriceRange(double min, double max) throws DaoException;

    public List<Product> findByCategory(int categoryId) throws DaoException;

    public List<Product> findBySupplier(int supplierId) throws DaoException;

    public List<Product> findByNamePattern(String namePattern) throws DaoException;
}
