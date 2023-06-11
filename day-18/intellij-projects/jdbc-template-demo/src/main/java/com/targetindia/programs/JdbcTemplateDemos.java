package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.util.List;
import java.util.Map;

@Slf4j
public class JdbcTemplateDemos {
    static JdbcTemplate jt;

    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            jt = ctx.getBean(JdbcTemplate.class);
            demo5();
        }// ctx.close() called here
    }

    private static void demo5() {
        // MULTIPLE ROWS, MULTIPLE COLUMNS
        String sql = "select product_name, unit_price from products where unit_price between ? and ?";
        // here the JdbcTemplate does the following:
        // 1. gets a connection using the injected DataSource
        // 2. creates a PreparedStatement using the sql given by us
        // 3. sets any parameters to the preparedStatement
        // 4. executes the sql command using the preparedStatement
        // 5. collects the ResultSet
        // 6. hands over the resultSet to our callback, so that we can process the current row
        // 7. once our callback is over, takes the control back, and
        // 8. closes all resources: rs.close(), stmt.close(), conn.close()
        // 9. handles any exceptions thrown by re-throwing them as DataAccessException
        RowCallbackHandler rch = (rs) -> {
            while (rs.next()) {
                log.trace("'{}' --> ${}", rs.getString(1), rs.getDouble(2));
            }
        };
        jt.query(sql, rch, 50, 500);
    }

    private static void demo4() {
        // MULTIPLE ROWS, ONE COLUMN
        String sql = "select product_name from products where discontinued = 1";
        List<String> productNames = jt.queryForList(sql, String.class);
        productNames.forEach(log::trace);
    }

    private static void demo3() {
        // ONE ROW, MULTIPLE COLUMNS
        String sql = "select product_name, unit_price from products where product_id=?";
        int productId = 43;
        Map<String, Object> result = jt.queryForMap(sql, productId);
        log.trace("'{}' costs ${}",
                result.get("product_name"),
                result.get("unit_price"));
    }

    private static void demo2() {
        // ONE ROW, ONE COLUMN (String type)
        String sql = "select company_name from customers where customer_id=?";
        String customerId = "ALFKI";
        String companyName = jt.queryForObject(sql, String.class, customerId);
        log.trace("Company name for customer id '{}' is '{}'", customerId, companyName);
    }

    static void demo1() {
        // ONE ROW, ONE COLUMN (long type)
        Long cc = jt.queryForObject("select count(*) from customers", Long.class);
        log.trace("There are {} customers", cc);
    }
}
