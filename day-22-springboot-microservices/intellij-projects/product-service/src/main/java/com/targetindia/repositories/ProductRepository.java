package com.targetindia.repositories;

import com.targetindia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // SQL --> select * from products where unit_price between ? and ?
    // JPQL--> from Product where unitPrice between ?1 and ?2
    // method name convention --> findAllBy<property-name>[<operator>](param1, param2)
    public List<Product> findAllByUnitPriceBetween(Double min, Double max);
}
