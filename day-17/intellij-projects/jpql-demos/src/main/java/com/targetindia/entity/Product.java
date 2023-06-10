package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    Integer productId;
    @Column(name = "product_name")
    String productName;
    @Column(name = "quantity_per_unit")
    String quantityPerUnit;

    @Column(name = "unit_price")
    Double unitPrice;
    @Column(name = "units_in_stock")
    Integer unitsInStock;
    @Column(name = "units_on_order")
    Integer unitsOnOrder;
    @Column(name = "reorder_level")
    Integer reorderLevel;
    @Column(name = "discontinued")
    Boolean discontinued;

    // Product HAS-A Category
    // Many products belong to one category
    // for every product, fetches the corresponding category using a join statement, eagerly!
    @ManyToOne //(fetch = FetchType.LAZY) // (fetch = FetchType.EAGER) is the default for @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    // Many products supplied by One Supplier
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;
}
