package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
public class CustomResponse {
    private String message;
    private Date timestamp = new Date();

    public CustomResponse(String message) {
        this.message = message;
    }
}
