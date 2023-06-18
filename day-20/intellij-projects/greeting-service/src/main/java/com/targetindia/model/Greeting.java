package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement // permission for any api to convert an object of this class into an XML string
public class Greeting {
    private String message;
    private Date timestamp = new Date();

    public Greeting(String message) {
        this.message = message;
    }
}
