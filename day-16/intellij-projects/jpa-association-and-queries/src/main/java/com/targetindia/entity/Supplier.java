package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_title")
    private String contactTitle;

    @Embedded
    private Address address; // represents address, city, region, postal_code, country columns of suppliers table

    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "home_page")
    private String homepage;

    // one suppliers supplies many products
    @OneToMany
    @JoinColumn(name = "supplier_id")
    private List<Product> products;
}
