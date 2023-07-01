package com.targetindia.programs;

import com.targetindia.config.AppConfig2;
import com.targetindia.dao.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class DisplayCustomerCount {
    public static void main(String[] args) {
        // @Value(..) used in AppConfig2 class may read the properties from System.properties as well
        // System.setProperty("jdbc.connection.password", "Welcome#123");
        // make sure to set this before the creation of spring container

        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class)
        ) {
            CustomerDao dao = ctx.getBean(CustomerDao.class);
            long cc = dao.count();
            log.trace("There are {} customers", cc);
        }
    }
}
