package com.targetindia.programs;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ReadNumbersFromBinaryFile {

    public static void main(String[] args) throws Exception {

        try (
                FileInputStream file = new FileInputStream("numbers.data");
                DataInputStream in = new DataInputStream(file);
        ) {
            while (true) {
                double num = 0;
                try {
                    num = in.readDouble();
                    System.out.println(num);
                } catch (EOFException e) {
                    break;
                }
            }
        } // file.close() and in.close() called here
    }

    public static void main1(String[] args) throws Exception {

        try (FileInputStream file = new FileInputStream("numbers.data");) {
            byte[] bytes = new byte[8];
            while (true) {
                int r = file.read(bytes);
                if (r == -1) {
                    break;
                }
                double num = ByteBuffer.wrap(bytes).getDouble();
                System.out.println(num);
            }
        }
    }
}
