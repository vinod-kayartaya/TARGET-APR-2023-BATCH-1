package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    private String description;
    private byte[] picture;

    // for this category object, go and get all records from the products table
    // using the foreign key PRODUCTS.CATEGORY_ID
    // One Category HAS-A Many Products
    @OneToMany(fetch = FetchType.EAGER) // (fetch = FetchType.LAZY) is the default of @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;
}