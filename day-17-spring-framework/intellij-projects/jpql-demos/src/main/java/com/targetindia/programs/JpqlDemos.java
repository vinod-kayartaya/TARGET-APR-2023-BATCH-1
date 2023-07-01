package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpqlDemos {
    static EntityManager em;

    static void printProduct(Product p) {
        System.out.printf("%3d - %s ($%.1f)%n",
                p.getProductId(), p.getProductName(), p.getUnitPrice());
    }

    public static void main(String[] args) {
        em = JpaUtil.createEntityManager();

        demo7();

        em.close();
    }

    private static void demo1() {
        String ql = "from Product";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        List<Product> list = qry.getResultList();
        list.forEach(JpqlDemos::printProduct);
    }

    static void demo2() {
        String ql = "from Product where unitPrice between ?1 and ?2 order by unitPrice desc";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter(1, 50);
        qry.setParameter(2, 500);
        qry.getResultList()
                .forEach(JpqlDemos::printProduct);
    }

    static void demo3() {
        String ql = "from Product where category.categoryName=:CAT_NAME and " +
                "unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice desc, productName";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter("CAT_NAME", "Beverages");
        qry.setParameter("MIN_PRICE", 10);
        qry.setParameter("MAX_PRICE", 20);
        qry.getResultList()
                .forEach(JpqlDemos::printProduct);
    }

    static void demo4() {
        int id = KeyboardUtil.getInt("Enter product id to search: ");
        String ql = "select productName from com.targetindia.entity.Product where productId=?1";
        TypedQuery<String> qry = em.createQuery(ql, String.class);
        qry.setParameter(1, id);
        try {
            String name = qry.getSingleResult();
            System.out.printf("Product id %d is '%s'%n", id, name);
        } catch (NoResultException nre) {
            System.out.println("Invalid id!");
        }
    }

    static void demo5() {
        int id = KeyboardUtil.getInt("Enter product id to search: ");
        String ql = "select productName, unitPrice from com.targetindia.entity.Product where productId=?1";
        TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
        qry.setParameter(1, id);
        Object[] result = qry.getSingleResult();
        System.out.printf("%s --> $%.2f%n", result[0], result[1]);
    }

    static void demo6() {
        double min = KeyboardUtil.getDouble("Enter min price: ");
        double max = KeyboardUtil.getDouble("Enter max price: ");
        String ql = "select productName, unitPrice from Product where unitPrice between ?1 and ?2";
        TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
        qry.setParameter(1, min);
        qry.setParameter(2, max);
        List<Object[]> list = qry.getResultList();

        for (Object[] row : list) {
            System.out.printf("%s --> $%.2f%n", row[0], row[1]);
        }
    }

    static void demo7() {
        // display paginated output
        int pageNum = KeyboardUtil.getInt("Enter page number: ");
        int pageSize = 10;
        int offset = (pageNum - 1) * pageSize;
        String ql = "from Product order by productId";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setFirstResult(offset);
        qry.setMaxResults(pageSize);

        List<Product> list = qry.getResultList();
        list.forEach(JpqlDemos::printProduct);
        if (list.size() == 0) {
            System.out.println("nothign to show");
        } else if (list.size() < pageSize) {
            System.out.println("This is the last page");
        }
        else {
            System.out.printf("This is page number %d%n", pageNum);
        }
    }

}
