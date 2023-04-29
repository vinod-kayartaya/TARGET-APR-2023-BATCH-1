package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j
public class ReadIntoCharArray {
    public static void main(String[] args) {

        String filename = "../../../Week-02-Assignment.md";
        try (
                FileReader reader = new FileReader(filename);
        ) {
            char[] buffer = new char[1024];
            int eof;
            int loopCount = 0;
            String text = "";
            while (true) {
                eof = reader.read(buffer);
                // log.trace("read {} chars from the file", eof);
                loopCount++;
                System.out.println(new String(buffer));
                if(eof==-1){
                    break;
                }
            }
            log.trace("Loop count = {}", loopCount);


        }// reader.close() is called here
        catch (Exception e) {
            log.error("there was an error", e);
        }
    }
}
