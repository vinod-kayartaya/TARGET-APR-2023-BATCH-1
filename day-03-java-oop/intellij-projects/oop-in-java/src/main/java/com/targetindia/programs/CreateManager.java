package com.targetindia.programs;

import com.targetindia.model.Manager;

public class CreateManager {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.setId(123);
        m.setFirstname("John");
        m.setSalary(200000);
        m.setDepartment("ACCOUNTING");
        m.setProjectCount(2);
        m.setEmail("johndoe@xmpl.com");
        m.print();
    }
}
