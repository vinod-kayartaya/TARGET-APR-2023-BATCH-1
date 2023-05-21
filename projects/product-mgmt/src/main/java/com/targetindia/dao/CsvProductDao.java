package com.targetindia.dao;

import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Slf4j
public class CsvProductDao implements ProductDao {
    private Map<Integer, Product> map = new TreeMap<>();

    private void loadProductsFromCsvFile() {
        try (
                FileInputStream file = new FileInputStream("products.csv");
        ) {
            int size = file.available();
            byte[] bytes = new byte[size];
            file.read(bytes);
            String[] lines = new String(bytes).split("\n");
            Stream.of(lines)    // stream of comma separated String
                    .map(line -> line.split(",")) // stream of String[]
                    .map(ar -> {
                        try {
                            Product p = new Product();
                            p.setId(Integer.parseInt(ar[0]));
                            p.setName(ar[1]);
                            p.setCategory(ar[2]);
                            p.setQuantityPerUnit(ar[3]);
                            p.setUnitPrice(Double.parseDouble(ar[4]));
                            p.setUnitsInStock(Integer.parseInt(ar[5]));
                            return p;
                        } catch (NumberFormatException e) {
                            log.warn("Error!", e);
                            return null;
                        }
                    }) // stream of Product
                    .forEach(p -> {
                        if (p != null) {
                            map.put(p.getId(), p);
                        }
                    });
        } catch (Exception e) {
            log.warn("Error!", e);
        }
    }

    public CsvProductDao() {
        loadProductsFromCsvFile();
    }

    private void saveProductsToCsvFile() {
        try (
                FileWriter writer = new FileWriter("products.csv");
                PrintWriter out = new PrintWriter(writer);
        ) {
            // write the header first
            out.println("id,name,category,quantity_per_unit,unit_price,units_in_stock");
            map.values()
                    .stream()
                    .map(p -> String.format("%s,%s,%s,%s,%s,%s",
                            p.getId(),
                            p.getName(),
                            p.getCategory(),
                            p.getQuantityPerUnit(),
                            p.getUnitPrice(),
                            p.getUnitsInStock())) // stream of comma separated string
                    .forEach(out::println);
        } catch (Exception e) {
            log.warn("Error!", e);
        }
    }


    @Override
    public void addProduct(Product p) throws DaoException {
        // after adding a product to the "map", call the saveProductsToCsvFile()
        map.put(p.getId(), p);
        saveProductsToCsvFile();
    }


    @Override
    public void updateProduct(Product p) throws DaoException {
        // after updating a product in the "map", call the saveProductsToCsvFile()
        if (map.containsKey(p.getId())) {
            map.put(p.getId(), p);
            saveProductsToCsvFile();
        } else {
            throw new DaoException("Invalid product id for update");
        }
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        // after deleting a product from the "map", call the saveProductsToCsvFile()
        if (map.containsKey(id)) {
            map.remove(id);
            saveProductsToCsvFile();
        } else {
            throw new DaoException("Invalid product id for update");
        }
    }

    public List<Product> getAllProducts() throws DaoException {
        List<Product> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return list;
    }

    public Product getProductById(int id) throws DaoException {
        return map.get(id);
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws DaoException {
        List<Product> list = new ArrayList<>();
        for (Product p : map.values()) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Product> getProductsByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException {
        return null;
    }
}
