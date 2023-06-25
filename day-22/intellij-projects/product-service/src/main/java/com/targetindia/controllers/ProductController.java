package com.targetindia.controllers;

import com.targetindia.entity.Product;
import com.targetindia.model.CustomResponse;
import com.targetindia.model.ProductDTO;
import com.targetindia.repositories.ProductRepository;
import com.targetindia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(path = "/{productId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetOne(@PathVariable Integer productId) {
        ProductDTO p = service.getProductForId(productId);
        if (p == null) {
            CustomResponse cr = new CustomResponse("No data found for id " + productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cr);
        }

        return ResponseEntity.ok(p);
    }
}
