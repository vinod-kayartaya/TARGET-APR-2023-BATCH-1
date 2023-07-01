package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DisplayResultOfQuery {
    public static void main(String[] args) {
        String sql = KeyboardUtil.getString("Enter any SQL SELECT statement: ");
        String filename = KeyboardUtil.getString("Enter filename to store the result: ");
        try (
                Connection conn = DbUtil.newConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                FileWriter writer = new FileWriter(filename);
                PrintWriter out = new PrintWriter(writer);
        ) {

            // write the column headings
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1, j = rsmd.getColumnCount(); i <= j; i++) {
                out.print(rsmd.getColumnName(i));
                if (i < j) {
                    out.print(",");
                }
            }
            out.println();

            while(rs.next()){
                for (int i = 1, j = rsmd.getColumnCount(); i <= j; i++) {
                    // protect/mask critical information
                    if(rsmd.getColumnName(i).contains("password") ||
                            rsmd.getColumnName(i).contains("email")){
                        out.print("*********");
                    }
                    else{
                        out.print(rs.getString(i));
                    }

                    if (i < j) {
                        out.print(",");
                    }
                }
                out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
