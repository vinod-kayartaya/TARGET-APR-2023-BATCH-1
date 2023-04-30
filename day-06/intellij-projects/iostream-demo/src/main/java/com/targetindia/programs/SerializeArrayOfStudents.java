package com.targetindia.programs;

import com.targetindia.model.Student;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeArrayOfStudents {
    public static void main(String[] args) throws Exception {
        Student[] students = {
                new Student(1234, "Suresh", "suresh@xmpl.com", 4.9),
                new Student(2233, "Robert", "robert@xmpl.com", 4.7),
                new Student(7788, "Kishore", "kishore@xmpl.com", 3.8)
        };

        try (
                FileOutputStream file = new FileOutputStream("students.data");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            for (Student s : students) {
                out.writeObject(s);
            }
        }
        System.out.println("Done!");
    }
}
