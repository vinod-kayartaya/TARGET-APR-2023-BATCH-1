package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.Serializable;

@Data
@XmlRootElement
public class Contact implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String city;
}
