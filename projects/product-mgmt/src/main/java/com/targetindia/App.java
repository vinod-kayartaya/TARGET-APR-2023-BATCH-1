package com.targetindia;

import com.targetindia.model.Product;
import com.targetindia.service.ProductManager;
import com.targetindia.service.ServiceException;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.List;

@Slf4j
public class App {

    ProductManager pm = new ProductManager();

    public void start() {
        int choice;

        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    displayProductForId();
                    break;
                case 3:
                    displayProductsForCategory();
                    break;
                case 6:
                    acceptAndAddProductDetails();
                    break;
                case 7:
                    editProductDetails();
                    break;
                case 4:
                case 5:
                    System.out.printf("Choice #%d is not ready yet!%n", choice);
                    break;
                case 8:
                    deleteProduct();
                    break;

                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }

        System.out.println("Thank you for using our app. Have a nice day");
    }

    private void deleteProduct() {
        try {
            int id = KeyboardUtil.getInt("Enter product id: ");
            Product p = pm.getProduct(id);

            if (p == null) {
                System.out.printf("No product found for id %d%n", id);
            } else {
                displayProductDetails(p);

                String ans = KeyboardUtil.getString("Are you sure to delete this product? (yes/no): (no) ");
                if(ans.equalsIgnoreCase("yes")){
                    pm.deleteProduct(id);
                    System.out.printf("Product with id %d is deleted successfully!%n", id);
                }
                else {
                    System.out.printf("Product with id %d IS NOT deleted.%n", id);
                }
            }

        } catch (Exception e) {
            System.out.printf("Invalid input. Please try again.");
            log.warn("Error while accepting id for deleting", e);
        }
    }

    private void editProductDetails() {
        try {
            int id = KeyboardUtil.getInt("Enter product id: ");
            Product p = pm.getProduct(id);
            if (p == null) {
                System.out.printf("No product found for the id %d%n", id);
                return;
            }

            String input;
            input = KeyboardUtil.getString(String.format("Enter name: (%s) ", p.getName()));
            if (!input.isBlank()) {
                p.setName(input);
            } // else p will retain its original value

            input = KeyboardUtil.getString(String.format("Enter category: (%s) ", p.getCategory()));
            if (!input.isBlank()) {
                p.setCategory(input);
            } // else p will retain its original value

            input = KeyboardUtil.getString(String.format("Enter quantity per unit: (%s) ", p.getQuantityPerUnit()));
            if (!input.isBlank()) {
                p.setQuantityPerUnit(input);
            } // else p will retain its original value

            input = KeyboardUtil.getString(String.format("Enter unit price: (%s) ", p.getUnitPrice()));
            if (!input.isBlank()) {
                try {
                    p.setUnitPrice(Double.parseDouble(input));
                } catch (NumberFormatException e) {
                    log.warn("user entered non-numeric value {} for unit price while editing product {}",
                            input, p, e);
                    System.out.println("Your entered value is ignored since it is non-numeric");
                }
            } // else p will retain its original value

            input = KeyboardUtil.getString(String.format("Enter units in stock: (%s) ", p.getUnitsInStock()));
            if (!input.isBlank()) {
                try {
                    p.setUnitsInStock(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    log.warn("user entered non-numeric value {} for units in stock while editing product {}",
                            input, p, e);
                    System.out.println("Your entered value is ignored since it is non-numeric");
                }
            } // else p will retain its original value

            pm.updateProduct(p);
            System.out.println("Product details have been updated successfully");
        } catch (Exception e) {
            System.out.printf("Invalid input. Please try again.");
            log.warn("Error while accepting id for editing", e);
        }
    }

    private void acceptAndAddProductDetails() {
        try {
            System.out.println("Enter new product details: ");
            int id = KeyboardUtil.getInt("ID               : ");
            String name = KeyboardUtil.getString("Name             : ");
            String category = KeyboardUtil.getString("Category         : ");
            String quantityPerUnit = KeyboardUtil.getString("Quantity per unit: ");
            double unitPrice = KeyboardUtil.getDouble("Unit price       : ");
            int unitsInStock = KeyboardUtil.getInt("Units in stock   : ");

            Product p = new Product();
            p.setId(id);
            p.setName(name);
            p.setCategory(category);
            p.setQuantityPerUnit(quantityPerUnit);
            p.setUnitPrice(unitPrice);
            p.setUnitsInStock(unitsInStock);

            pm.addNewProduct(p);
            System.out.println("New product data added successfully!");


        } catch (InputMismatchException e) {
            System.out.println("Wrong value type!");
        } catch (ServiceException e) {
            System.out.printf("Encountered one or more errors: %n%s%n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("There was an error: %s%n", e.getMessage());
        }
        line();
    }

    private void displayProductsForCategory() {
        try {
            String category = KeyboardUtil.getString("Enter category to search: ");
            List<Product> products = pm.getProductsByCategory(category);
            if (products.size() == 0) {
                System.out.printf("No products found in the category '%s'%n", category);
            } else {
                displayGivenProducts(products);
            }
        } catch (Exception e) {
            System.out.printf("There was an error: %s%n", e.getMessage());
        }
    }

    private void displayProductForId() {
        try {
            int id = KeyboardUtil.getInt("Enter id to search: ");
            Product p = pm.getProduct(id);
            if (p == null) {
                System.out.printf("No product found for id %d%n", id);
            } else {
                displayProductDetails(p);
            }
        } catch (InputMismatchException e) {
            System.out.printf("Invalid value type for id%n");
        } catch (Exception e) {
            System.out.printf("There was an error: %s%n", e.getMessage());
        }
    }

    private static void displayProductDetails(Product p) {
        System.out.printf("Name          : %s%n", p.getName());
        System.out.printf("Category      : %s%n", p.getCategory());
        System.out.printf("Unit price    : %s%n", p.getUnitPrice());
        System.out.printf("Units in stock: %s%n", p.getUnitsInStock());
        System.out.printf("Quantity desc : %s%n%n", p.getQuantityPerUnit());
    }

    void line() {
        line('-', 80);
    }

    void line(char pattern) {
        line(pattern, 80);
    }

    void line(int len) {
        line('-', len);
    }

    void line(char pattern, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%c", pattern);
        }
        System.out.println();
    }

    private void displayAllProducts() {
        try {
            List<Product> list = pm.getAllProducts();
            displayGivenProducts(list);
        } catch (Exception e) {
            System.out.printf("There was an error: %s%n", e.getMessage());
        }
    }

    private void displayGivenProducts(List<Product> list) {
        line(109);
        System.out.printf("%4s %-30s %-20s %-30s %10s %10s%n",
                "ID",
                "Name",
                "Category",
                "Description",
                "Price",
                "Stock");
        line(109);
        for (Product p : list) {
            System.out.printf("%4d %-30s %-20s %-30s %10.2f %10d%n",
                    p.getId(),
                    p.getName(),
                    p.getCategory(),
                    p.getQuantityPerUnit(),
                    p.getUnitPrice(),
                    p.getUnitsInStock());
        }
        line('=', 109);
    }

    int menu() {
        try {
            System.out.println("*** MAIN MENU ***");
            System.out.println("0. Exit");
            System.out.println("1. List all products");
            System.out.println("2. Search product by id");
            System.out.println("3. Search products by category");
            System.out.println("4. Search products by name");
            System.out.println("5. Search products by price range");
            System.out.println("6. Add new product");
            System.out.println("7. Update existing product details");
            System.out.println("8. Delete a product details");

            int choice = KeyboardUtil.getInt("Enter your choice: (0-8) ");
            return choice;
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        log.trace("starting the app");
        new App().start();
        log.trace("terminating the app gracefully");
    }
}
