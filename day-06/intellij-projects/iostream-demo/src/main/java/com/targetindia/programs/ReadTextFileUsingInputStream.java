package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadTextFileUsingInputStream {
    static String filename = "src/main/java/com/targetindia/programs/ReadLineFromKeyboard.java";
    // 1284 bytes

    public static void main(String[] args) throws Exception {
        // Instead of using the FileInputStream for reading content of a text file,
        // we should use the FileReader + BufferedReader.
        // This is only to illustrate the reading of a text content coming from any other
        // form of InputStream, like SocketInputStream or ServletInputStream.
        try (
                FileInputStream file = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(file);
                BufferedReader in = new BufferedReader(isr);
        ) {
            String line;
            while((line=in.readLine())!=null){
                System.out.println(line);
            }
        } // file.close(), isr.close() and in.close() called here!
    }

    public static void main3(String[] args) throws Exception {
        // Instead of using the FileInputStream for reading content of a text file,
        // we should use the FileReader + BufferedReader.
        // This is only to illustrate the reading of a text content coming from any other
        // form of InputStream, like SocketInputStream or ServletInputStream.
        try (
                FileInputStream file = new FileInputStream(filename);
                DataInputStream in = new DataInputStream(file);
        ) {
            // read line by line
            String line;
            while ((line = in.readLine()) != null) { // avoid the use of this deprecated method
                System.out.println(line);
            }
        } // file.close() and in.close() called here
    }


    // static String filename = "C:\\Users\\user\\Videos\\Captures\\Settings 2023-04-27 13-54-14.mp4";
    // (14,802,334  bytes)
    public static void main2(String[] args) throws Exception {
        try (FileInputStream file = new FileInputStream(filename);) {
            int size = file.available(); // in most cases, this is the size of the file
            // but if the size of the file is too huge, then it returns an estimate of how much it can read
            byte[] bytes = new byte[size];
            file.read(bytes);
            String content = new String(bytes);
            System.out.println(content);
        } // file.close() is called always here
    }

    public static void main1(String[] args) throws Exception {
        FileInputStream file = new FileInputStream(filename);
        StringBuffer sb = new StringBuffer(1500);
        int ch;
        while ((ch = file.read()) != -1) {
            sb.append((char) ch);
        }
        file.close();

        String content = sb.toString();
        System.out.println(content);

    }
}
