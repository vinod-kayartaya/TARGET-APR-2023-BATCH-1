package com.targetindia.service;

import com.targetindia.entity.Product;
import com.targetindia.model.CategoryDTO;
import com.targetindia.model.ProductDTO;
import com.targetindia.model.SupplierDTO;
import com.targetindia.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @Value(("${category.service.url}"))
    private String categoryServiceUrl;

    @Value(("${supplier.service.url}"))
    private String supplierServiceUrl;

    // a simple cache
    private Map<Integer, CategoryDTO> categoryCache = new HashMap<>();
    private Map<Integer, SupplierDTO> supplerCache = new HashMap<>();

    public ProductDTO getProductForId(Integer productId) {
        Optional<Product> result = repo.findById(productId);

        if (result.isPresent()) {
            return getProductDTO(result.get());
        }
        return null;
    }

    public List<ProductDTO> getAll(int pageNum, int pageSize) {
        PageRequest pr = PageRequest.of(pageNum - 1, pageSize);
        return repo.findAll(pr)
                .stream()
                .map(this::getProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setQuantityPerUnit(product.getQuantityPerUnit());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setUnitsOnOrder(product.getUnitsOnOrder());
        productDTO.setReorderLevel(product.getReorderLevel());
        productDTO.setDiscontinued(product.getDiscontinued());

        // we have to visit the category-service rest endpoint and
        // get the category information, create a CategoryDTO object,
        // and set the same in productDTO
        // i.e, productDTO.setCategory(..)

        // old method --> use RestTemplate
        // new method --> use WebClient (needs an additional pom.xml dependency)

        CategoryDTO categoryDTO = null;

        if (categoryCache.containsKey(product.getCategoryId())) {
            categoryDTO = categoryCache.get(product.getCategoryId());
            log.debug("got the category from the cache - {}", categoryDTO);
        } else {
            try {
                log.debug("visiting {} for product id {} with category id {}",
                        categoryServiceUrl, product.getProductId(), product.getCategoryId());

                categoryDTO = restTemplate.getForObject(
                        categoryServiceUrl + product.getCategoryId(),
                        CategoryDTO.class);
                categoryCache.put(categoryDTO.getId(), categoryDTO);
            } catch (RestClientException e) {
                log.warn("error while fetching category from category-service", e);
                // nothing can be done, let's not give error to the user
                // send only the product information without category information
            }
        }

        SupplierDTO supplierDTO = null;

        if(supplerCache.containsKey(product.getSupplierId())){
            supplierDTO=supplerCache.get(product.getSupplierId());
            log.debug("got the supplier from the cache - {}", supplierDTO);

        }
        else {
            try {
                log.debug("visiting {} for product id {} with supplier id {}",
                        supplierServiceUrl, product.getProductId(), product.getSupplierId());

                supplierDTO = WebClient.create(supplierServiceUrl + product.getSupplierId())
                        .get()
                        .retrieve()
                        .bodyToMono(SupplierDTO.class)
                        .block();
                supplerCache.put(supplierDTO.getSupplierId(), supplierDTO);
            } catch (Exception e) {
                log.warn("error while fetching supplier from supplier-service", e);
            }
        }



        productDTO.setCategory(categoryDTO);
        productDTO.setSupplier(supplierDTO);

        return productDTO;
    }

    public List<ProductDTO> getByPriceRange(Double min, Double max) {
        return repo.findAllByUnitPriceBetween(min, max)
                .stream()
                .map(this::getProductDTO)
                .collect(Collectors.toList());

    }

    public ProductDTO addNewProduct(Product product) {
        product.setProductId(null); // so that JPA will generate new ID and assign to this product
        Product p = repo.save(product);
        return getProductDTO(p);
    }

    public ProductDTO updateProduct(Product product) throws ServiceException {
        if (repo.existsById(product.getProductId())) {
            Product p = repo.save(product); // since the id is already present, the record gets updated
            return getProductDTO(p);
        }
        throw new ServiceException("No product found for the given id");
    }
}
