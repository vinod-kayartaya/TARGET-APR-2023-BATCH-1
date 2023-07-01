package com.targetindia.programs;

import com.targetindia.config.AppConfig2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class)
        ) {

            DataSource ds = ctx.getBean(DataSource.class);
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("select count(*) as cnt from products")) {
                if(rs.next()){
                    log.trace("There are {} products", rs.getInt("cnt"));
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
