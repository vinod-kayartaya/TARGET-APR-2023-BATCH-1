package com.targetindia.programs;

import com.targetindia.utils.DbUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ListTablesInDatabase {
    public static void main(String[] args) throws Exception {

        try (
                Connection conn = DbUtil.newConnection();
        ) {
            DatabaseMetaData dmd = conn.getMetaData();
            try (ResultSet rs = dmd.getTables("targetdb_b1", null, null, null);) {
                System.out.println("The resultset coming from dmd.getTables contains the following fields: ");
//                ResultSetMetaData rsmd = rs.getMetaData();
//                for(int i=1; i<=rsmd.getColumnCount(); i++){
//                    System.out.println(rsmd.getColumnName(i));
//                }

                while (rs.next()) {
                    System.out.printf("%-30s %-30s%n",
                            rs.getString("TABLE_NAME"),
                            rs.getString("TABLE_CAT"));
                }
            }
        }
    }
}

