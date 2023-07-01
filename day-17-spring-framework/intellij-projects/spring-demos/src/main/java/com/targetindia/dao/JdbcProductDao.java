package com.targetindia.dao;

public class JdbcProductDao implements ProductDao{
    @Override
    public String getProductName(int productId) {
        return "Unknown product name";
    }
}
