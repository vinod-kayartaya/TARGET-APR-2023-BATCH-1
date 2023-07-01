package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JPQLDemo {
    static EntityManager em;

    static void demo1() {
        // get all categories
        // SQL --> select category_id, category_name, description, picture from categories
        // SQL --> select * from categories
        // SQL --> works using table names and column names
        // SQL --> '*' means all columns of a given row, which in Java, can be represented by
        // an object of the corresponding entity class (i.e, Category, Product, Supplier)

        // JPQL --> works using Class and properties (member variables with getter/setter)
        // JPQL --> select c from Category c
        // 'c' contains categoryId, categoryName, description, picture
        String jpql = "select c from Category c";
        // EntityManager provides CRUD operations on the primary_key column
        // In order to perform Query operations, we need an object of Query or TypeQuery
        TypedQuery<Category> qry = em.createQuery(jpql, Category.class);
        qry.getResultStream()
                .forEach(c -> System.out.printf("%s (%s)%n", c.getCategoryName(), c.getDescription()));
    }

    static void demo2() {
        // get the list of products priced with in a range
        double min = KeyboardUtil.getDouble("Enter minimum price: ");
        double max = KeyboardUtil.getDouble("Enter maximum price: ");
//        String ql = "select p from Product p where p.unitPrice between ?1 and ?2";
//        String ql = "select p from Product p where p.unitPrice between ?1 and ?2 order by p.unitPrice";
        String ql = "from Product where unitPrice between ?1 and ?2 order by unitPrice desc, productName";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter(1, min);
        qry.setParameter(2, max);
        qry.getResultStream().forEach(JPQLDemo::printProductInfo);
    }

    static void printProductInfo(Product p) {
        System.out.printf("%s --> $ %.2f%n",
                p.getProductName(), p.getUnitPrice());
    }

    public static void main(String[] args) {
        em = JpaUtil.createEntityManager();

        demo2();

        em.close();
    }
}
