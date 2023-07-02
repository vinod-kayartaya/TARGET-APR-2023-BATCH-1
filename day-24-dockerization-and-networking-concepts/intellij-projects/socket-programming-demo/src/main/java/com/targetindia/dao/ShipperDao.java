package com.targetindia.dao;

import com.targetindia.model.Shipper;
import com.targetindia.utils.DbUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShipperDao {

    @SneakyThrows
    public List<Shipper> findAll() {
        List<Shipper> shippers = new ArrayList<>();
        String sql = "select * from shippers";
        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {
                Shipper s1 = new Shipper();
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setPhone(rs.getString(3));
                shippers.add(s1);
            }
            return shippers;
        }
    }

    @SneakyThrows
    public Shipper findById(Integer id) {
        String sql = "select * from shippers where shipper_id=?";
        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Shipper s1 = new Shipper();
                    s1.setId(rs.getInt(1));
                    s1.setName(rs.getString(2));
                    s1.setPhone(rs.getString(3));
                    return s1;
                } else {
                    return null;
                }
            }
        }
    }
}
