package com.targetindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @Column(name = "address")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
}
