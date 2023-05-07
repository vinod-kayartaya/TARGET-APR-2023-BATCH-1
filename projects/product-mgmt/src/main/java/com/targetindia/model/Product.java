package com.targetindia.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String category;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitsInStock;
}
