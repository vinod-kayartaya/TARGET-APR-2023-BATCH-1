package com.targetindia.model;

import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class ProductDTO {
    private Integer productId;
    private String productName;

    private CategoryDTO category;

    private SupplierDTO supplier;

    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Integer discontinued;

}
