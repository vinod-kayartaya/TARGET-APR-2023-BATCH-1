package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@XmlRootElement
public class ErrorInfo {
    private String message;
    private Date timestamp = new Date();
    private String exceptionClassName;

    public ErrorInfo(String message) {
        this.message = message;
    }

    public ErrorInfo(String message, String exceptionClassName) {
        this.message = message;
        this.exceptionClassName = exceptionClassName;
    }
}
