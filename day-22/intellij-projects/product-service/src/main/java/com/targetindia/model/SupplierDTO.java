package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SupplierDTO {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;

    private Address address;

    private String phone;
    private String fax;

    @Data
    class Address {
        private String streetAddress;
        private String city;
        private String region;
        private String postalCode;
        private String country;
    }
}
