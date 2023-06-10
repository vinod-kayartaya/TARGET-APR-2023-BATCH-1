package com.targetindia.dao;

public class DummyProductDao implements ProductDao{
    @Override
    public String getProductName(int productId) {
        return "Dummy";
    }
}
