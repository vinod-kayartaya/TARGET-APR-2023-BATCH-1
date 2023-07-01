package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDTO {
    @JsonProperty("categoryId")
    @XmlElement(name="categoryId")
    private Integer id;

    @JsonProperty("categoryName")
    @XmlElement(name="categoryName")
    private String name;

    private String description;
}
