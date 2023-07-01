package com.targetindia.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class JdbcCustomerDao implements CustomerDao {

    // this class has a dependency of javax.sql.DataSource
    @Autowired
    private DataSource dataSource;

    @Override
    public long count() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) as cnt from customers")
        ) {
            rs.next();
            return rs.getLong("cnt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
