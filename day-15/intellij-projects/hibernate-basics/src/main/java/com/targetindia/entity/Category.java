package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

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
}

// select categoryName, description, picture from Category where categoryId = ?
// select category_name, description, picture from categories where category_id = ?