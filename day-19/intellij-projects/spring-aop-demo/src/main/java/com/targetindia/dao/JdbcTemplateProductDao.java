package com.targetindia.dao;

import com.targetindia.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateProductDao implements ProductDao {

    @Autowired
    private JdbcTemplate template;

    static RowMapper<Product> prm = (rs, rowNum) -> {
        Product p = new Product();
        p.setProductId(rs.getInt("product_id"));
        p.setProductName(rs.getString("product_name"));
        p.setSupplierId(rs.getInt("supplier_id"));
        p.setCategoryId(rs.getInt("category_id"));
        p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
        p.setUnitPrice(rs.getDouble("unit_price"));
        p.setUnitsInStock(rs.getInt("units_in_stock"));
        p.setUnitsOnOrder(rs.getInt("units_on_order"));
        p.setReorderLevel(rs.getInt("reorder_level"));
        p.setDiscontinued(rs.getInt("discontinued"));
        return p;
    };

    @Override
    public void create(Product p) throws DaoException {
        String sql = "insert into products values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatementCallback<Integer> psc = (ps) -> {
            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getSupplierId());
            ps.setInt(4, p.getCategoryId());
            ps.setString(5, p.getQuantityPerUnit());
            ps.setDouble(6, p.getUnitPrice());
            ps.setInt(7, p.getUnitsInStock());
            ps.setInt(8, p.getUnitsOnOrder());
            ps.setInt(9, p.getReorderLevel());
            ps.setInt(10, p.getDiscontinued());
            return ps.executeUpdate();
        };
        template.execute(sql, psc);
    }

    @Override
    public Product findById(int productId) throws DaoException {
        return template.queryForObject("select * from products where product_id=?", prm, productId);
    }

    @Override
    public void update(Product p) throws DaoException {
        String sql = "update products set product_name=?, supplier_id=?, category_id=?, quantity_per_unit=?, " +
                "unit_price=?, units_in_stock=?, units_on_order=?, reorder_level=?, discontinued=? where " +
                "product_id=?";
        PreparedStatementCallback<Integer> psc = (ps) -> {
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getSupplierId());
            ps.setInt(3, p.getCategoryId());
            ps.setString(4, p.getQuantityPerUnit());
            ps.setDouble(5, p.getUnitPrice());
            ps.setInt(6, p.getUnitsInStock());
            ps.setInt(7, p.getUnitsOnOrder());
            ps.setInt(8, p.getReorderLevel());
            ps.setInt(9, p.getDiscontinued());
            ps.setInt(10, p.getProductId());
            return ps.executeUpdate();
        };
        template.execute(sql, psc);
    }

    @Override
    public void delete(int productId) throws DaoException {
        String sql = "delete from products where product_id=?";
        PreparedStatementCallback<Integer> psc = (ps) -> {
            ps.setInt(1, productId);
            int c = ps.executeUpdate();
            if (c == 0) {
                throw new DaoException("No data found for id " + productId);
            }
            return c;
        };
        template.execute(sql, psc);
    }

    @Override
    public List<Product> findAll() throws DaoException {
        return template.query("select * from products", prm);
    }

    @Override
    public List<Product> findAllDiscontinuedProducts() throws DaoException {
        return template.query("select * from products where discontinued=1", prm);
    }

    @Override
    public List<Product> findAllOutOfStockProducts() throws DaoException {
        return template.query("select * from products where units_in_stock=0", prm);
    }

    @Override
    public List<Product> findByPriceRange(double min, double max) throws DaoException {
        return template.query("select * from products where unit_price between ? and ?", prm, min, max);
    }

    @Override
    public List<Product> findByCategory(int categoryId) throws DaoException {
        return template.query("select * from products where category_id=?", prm, categoryId);
    }

    @Override
    public List<Product> findBySupplier(int supplierId) throws DaoException {
        return template.query("select * from products where supplier_id=?", prm, supplierId);
    }

    @Override
    public List<Product> findByNamePattern(String namePattern) throws DaoException {
        return template.query("select * from products where lower(product_name) like lower(?)",
                prm, "%" + namePattern + "%");
    }
}
