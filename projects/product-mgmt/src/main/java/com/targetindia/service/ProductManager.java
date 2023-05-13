package com.targetindia.service;

import com.targetindia.dao.ArrayListProductDao;
import com.targetindia.dao.DaoFactory;
import com.targetindia.dao.HashMapProductDao;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    // dependency
    // ProductDao dao = new HashMapProductDao(); // tight coupling; should be avoided
    ProductDao dao = DaoFactory.getProductDao();

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public Product getProduct(int id) {
        return dao.getProductById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return dao.getProductsByCategory(category);
    }

    public void addNewProduct(Product p) {
        List<String> errors = new ArrayList<>();
        if (p.getId() <= 0) {
            errors.add("Id cannot be negative or zero");
        }
        if (p.getUnitPrice() < 0) {
            errors.add("Unit price cannot be negative");
        }
        if (p.getUnitsInStock() < 0) {
            errors.add("Units in stock cannot be negative");
        }
        if (p.getName().isBlank()) {
            errors.add("Name cannot be blank");
        }
        if (p.getCategory().isBlank()) {
            errors.add("Category cannot be blank");
        }
        if (dao.getProductById(p.getId()) != null) {
            errors.add("There is a product already with the given id");
        }

        if (errors.size() > 0) {
            StringBuilder sb = new StringBuilder(1000);
            for (int i = 1, j = errors.size(); i <= j; i++) {
                sb.append(i)
                        .append(". ")
                        .append(errors.get(i - 1))
                        .append('\n');
            }
            throw new ServiceException(sb.toString());
        }

        dao.addProduct(p);

    }

}
