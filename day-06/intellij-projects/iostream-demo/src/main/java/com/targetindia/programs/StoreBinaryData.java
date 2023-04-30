package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class StoreBinaryData {
    public static void main(String[] args) throws Exception{
        String filename = "numbers.data";

        try(
                FileOutputStream file = new FileOutputStream(filename);
                DataOutputStream out = new DataOutputStream(file);
                ){

            while(true){
                double input = KeyboardUtil.getDouble("Enter a number (0 to stop): ");
                if(input==0) {
                    break;
                }

                out.writeDouble(input);
            }

        } // out.close() and file.close() are called
        System.out.println("Done!");
    }
}
