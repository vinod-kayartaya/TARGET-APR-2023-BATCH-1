package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;

import java.util.ResourceBundle;

@Slf4j
public final class DaoFactory {
    // factory for manufacturing objects of Dao types (such as ProductDao)

    private DaoFactory() {
    }

//    public static ProductDao getProductDao() throws DaoException{
//        ResourceBundle rb = ResourceBundle.getBundle("dao");
//        try {
//            String discriminator = rb.getString("ProductDao.discriminator");
//            return getProductDao(discriminator.trim());
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//    }

    public static ProductDao getProductDao() throws DaoException{
        ResourceBundle rb = ResourceBundle.getBundle("dao");
        try {
            String productDaoImplClassName = rb.getString("ProductDao.impl.class");

            return (ProductDao) Class.forName(productDaoImplClassName)
                    .getDeclaredConstructor()
                    .newInstance();

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public static ProductDao getProductDao(String discriminator)  throws DaoException{
        switch (discriminator.toLowerCase()) {
            case "arraylist":
                return new ArrayListProductDao();
            case "hashmap":
                return new HashMapProductDao();
            default:
                throw new DaoException("Request for unknown implementation of ProductDao");
        }
    }
}
