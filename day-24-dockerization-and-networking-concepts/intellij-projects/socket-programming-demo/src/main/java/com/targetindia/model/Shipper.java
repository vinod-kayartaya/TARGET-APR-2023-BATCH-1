package com.targetindia.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shipper implements Serializable {
    private Integer id;
    private String name;
    private String phone;
}
