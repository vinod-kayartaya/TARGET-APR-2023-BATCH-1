package com.targetindia.model;

import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidPriceException;
import com.targetindia.exceptions.NullNameException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String name;
    private double price;

    public void setId(int id) throws InvalidIdException {
        if (id <= 0) {
            throw new InvalidIdException("ID must be > 0");
        }
        this.id = id;
    }

    public void setName(String name) throws NullNameException, BlankNameException {
        if (name == null) {
            throw new NullNameException("Product name cannot be null");
        }
        if (name.isBlank()) {
            throw new BlankNameException("Product name cannot be blank");
        }
        this.name = name;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price <= 0) {
            throw new InvalidPriceException("Product price must be > 0");
        }

        this.price = price;
    }
}
