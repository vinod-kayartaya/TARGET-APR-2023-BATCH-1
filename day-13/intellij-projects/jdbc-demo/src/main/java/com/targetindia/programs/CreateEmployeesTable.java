package com.targetindia.programs;

import com.targetindia.utils.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

public class CreateEmployeesTable {
    public static void main(String[] args) throws Exception {

        String sql1 = "drop table if exists employees";

        String sql2 = "create table employees(\n" +
                "    id int primary key,\n" +
                "    first_name varchar(20) not null,\n" +
                "    last_name varchar(20),\n" +
                "    email varchar(50) unique,\n" +
                "    phone varchar(50) unique,\n" +
                "    salary double check (salary>=25000),\n" +
                "    department varchar(30) default 'ADMINISTRATION'\n" +
                ")";

        try (
                Connection conn = DbUtil.newConnection();
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql1); // the first round-trip to the DB server
            stmt.execute(sql2); // the second round-trip to the DB server
            System.out.println("Table created successfully!");
        } // conn.close() here
    }
}
