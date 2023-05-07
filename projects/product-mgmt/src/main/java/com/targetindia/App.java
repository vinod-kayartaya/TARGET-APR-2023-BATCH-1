package com.targetindia;

import com.targetindia.model.Product;
import com.targetindia.service.ProductManager;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

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
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    System.out.printf("Choice #%d is not ready yet!%n", choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }

        System.out.println("Thank you for using our app. Have a nice day");
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
        List<Product> list = pm.getAllProducts();
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
