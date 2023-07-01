package com.targetindia.programs;

import com.targetindia.model.Student;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DisplayStudentsFromFile {
    public static void main(String[] args) throws Exception {
        try (
                FileInputStream file = new FileInputStream("students.data");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while (true) {
                try {
                    Student s = (Student) in.readObject();
                    s.print();
                } catch (EOFException e) {
                    break;
                }
            }
        }
        System.out.println("Done!");
    }
}
