package com.targetindia.service;

import com.targetindia.dao.HashMapProductDao;
import com.targetindia.model.Product;

import java.util.List;

public class ProductManager {

    HashMapProductDao dao = new HashMapProductDao(); // tight coupling; should be avoided

    public List<Product> getAllProducts(){
        return dao.getAllProducts();
    }
}
