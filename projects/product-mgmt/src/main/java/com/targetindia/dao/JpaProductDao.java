package com.targetindia.dao;

import com.targetindia.model.Product;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;

import java.util.List;

public class JpaProductDao implements ProductDao {
    @Override
    public void addProduct(Product p) throws DaoException {
        p.setId(null); // ignore the id given by the user, and let the db server generate one
        try (EntityManager em = JpaUtil.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(p); // "p" is kept in the entity-manager cache, and has a status of 'new'.
                // the sql INSERT command is not executed here
                tx.commit(); // All of SQL commands (INSERT/UPDATE/DELETE) commands are executed, based on the
                // status of entity objects in the entity-manager cache:
                // 'new' --> INSERT
                // 'dirty' --> UPDATE
                // 'removed' --> DELETE
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        } // em.close() called here, and DB connection is also closed
        catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product getProductById(int id) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            return em.find(Product.class, id);
        }// em.close() called here, and DB connection is also closed
        catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateProduct(Product p) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(p); // "p" is kept in the entity-manager cache, will not have a status of 'dirty'.
                // the sql UPDATE command is not executed here

                tx.commit(); // All of SQL commands (INSERT/UPDATE/DELETE) commands are executed, based on the
                // status of entity objects in the entity-manager cache:
                // 'new' --> INSERT
                // 'dirty' --> UPDATE
                // 'removed' --> DELETE
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        } // em.close() called here, and DB connection is also closed
        catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            Product p = em.find(Product.class, id);
            if (p == null) {
                throw new DaoException("Invalid id " + id + " for deletion");
            }

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.remove(p); // "p" in the entity-manager cache, will not have a status of 'removed'.
                // the sql DELETE command is not executed here

                tx.commit(); // All of SQL commands (INSERT/UPDATE/DELETE) commands are executed, based on the
                // status of entity objects in the entity-manager cache:
                // 'new' --> INSERT
                // 'dirty' --> UPDATE
                // 'removed' --> DELETE
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        } // em.close() called here, and DB connection is also closed
        catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            TypedQuery<Product> qry = em.createQuery("from Product", Product.class);
            return qry.getResultList();
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            TypedQuery<Product> qry = em.createQuery(
                    "from Product where lower(category)=lower(?1)", Product.class);
            qry.setParameter(1, category);
            return qry.getResultList();
        }
    }

    @Override
    public List<Product> getProductsByName(String name) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            TypedQuery<Product> qry = em.createQuery(
                    "from Product where lower(name) like lower(?1)", Product.class);
            qry.setParameter(1, "%" + name + "%");
            return qry.getResultList();
        }
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException {
        try (EntityManager em = JpaUtil.createEntityManager()) {
            TypedQuery<Product> qry = em.createQuery(
                    "from Product where unitPrice between ?1 and ?2", Product.class);
            qry.setParameter(1, min);
            qry.setParameter(2, max);
            return qry.getResultList();
        }
    }
}
