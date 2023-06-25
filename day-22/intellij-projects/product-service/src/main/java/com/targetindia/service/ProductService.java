package com.targetindia.service;

import com.targetindia.entity.Product;
import com.targetindia.model.ProductDTO;
import com.targetindia.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public ProductDTO getProductForId(Integer productId) {
        Optional<Product> result = repo.findById(productId);

        if(result.isPresent()){
            // need to convert the entity-product to a product-dto
            Product product = result.get();
            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());
            productDTO.setQuantityPerUnit(product.getQuantityPerUnit());
            productDTO.setUnitPrice(product.getUnitPrice());
            productDTO.setUnitsInStock(product.getUnitsInStock());
            productDTO.setUnitsOnOrder(product.getUnitsOnOrder());
            productDTO.setReorderLevel(product.getReorderLevel());
            productDTO.setDiscontinued(product.getDiscontinued());
            return productDTO;
        }

        return null;
    }
}
