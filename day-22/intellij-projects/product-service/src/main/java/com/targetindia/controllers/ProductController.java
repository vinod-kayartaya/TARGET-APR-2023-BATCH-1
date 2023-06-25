package com.targetindia.controllers;

import com.targetindia.entity.Product;
import com.targetindia.model.CustomResponse;
import com.targetindia.model.ProductDTO;
import com.targetindia.model.ProductListDTO;
import com.targetindia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PutMapping(path="/{productId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handlePut(@PathVariable Integer productId, @RequestBody Product product){
        try{
            product.setProductId(productId); // so that the product id in the table is not changed
            ProductDTO p = service.updateProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        catch (Exception e){
            CustomResponse cr = new CustomResponse(e.getMessage());
            return ResponseEntity.status(491).body(cr);
        }
    }
    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handlePost(@RequestBody Product product){
        try{
            ProductDTO p = service.addNewProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        catch (Exception e){
            CustomResponse cr = new CustomResponse(e.getMessage());
            return ResponseEntity.status(491).body(cr);
        }
    }

    @GetMapping(path = "/by-price-range", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetByPriceRange(
            @RequestParam(name = "min", defaultValue = "0") Double min,
            @RequestParam(name = "max", defaultValue = "999999") Double max
    ) {
        return ResponseEntity.ok(new ProductListDTO(service.getByPriceRange(min, max)));
    }


    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetAll(
            @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "limit", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(new ProductListDTO(service.getAll(pageNum, pageSize)));
    }

    @GetMapping(path = "/{productId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleGetOne(@PathVariable Integer productId) {
        ProductDTO p = service.getProductForId(productId);
        if (p == null) {
            CustomResponse cr = new CustomResponse("No data found for id " + productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cr);
        }

        return ResponseEntity.ok(p);
    }
}
