package com.targetindia.model;

import lombok.Data;

@Data
public  class Artist extends Person{
    private String type; // painter, singer, dancer, actor, etc

    @Override
    public String getGrade() {
        return "Grade A";
    }
}
