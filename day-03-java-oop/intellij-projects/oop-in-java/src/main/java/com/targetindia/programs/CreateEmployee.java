package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class CreateEmployee {
    // static Logger log = LoggerFactory.getLogger(CreateEmployee.class);
    // Loggers have  LEVEL of severity for logged messages
    // TRACE < DEBUG < INFO < WARN < ERROR

    public static void main(String[] args) {
        Employee e1;
        e1 = new Employee();
        e1.setId(1122);
        e1.setSalary(3847);
        e1.setFirstname("John");
        e1.setLastname("Doe");
        e1.setEmail("johndoe@xmpl.com");
        e1.setPhone("555 938 2234");
        e1.setDepartment("ADMIN");

        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is a info message");
        log.warn("This is a warn message");
        log.error("This is a error message");

        e1.print();
    }
}
