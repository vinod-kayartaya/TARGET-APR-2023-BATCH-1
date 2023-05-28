package com.targetindia.dao;

import com.targetindia.model.Product;
import com.targetindia.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    @Override
    public void addProduct(Product p) throws DaoException {

    }

    @Override
    public Product getProductById(int id) throws DaoException {
        return null;
    }

    @Override
    public void updateProduct(Product p) throws DaoException {

    }

    @Override
    public void deleteProduct(int id) throws DaoException {

    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        List<Product> list = new ArrayList<>();

        try (
                Connection conn = DbUtil.newConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from products");
        ) {
            while (rs.next()) {
                Product p = getProduct(rs);
                list.add(p);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws DaoException {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where lower(category) =lower(?)";
        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);

        ) {
            stmt.setString(1, category);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Product p = getProduct(rs);
                    list.add(p);
                }
            }

        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }

    private static Product getProduct(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
        p.setUnitsInStock(rs.getInt("units_in_stock"));
        p.setUnitPrice(rs.getDouble("unit_price"));
        p.setCategory(rs.getString("category"));
        return p;
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
