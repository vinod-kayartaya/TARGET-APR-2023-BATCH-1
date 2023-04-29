package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class AutoCloseableDemo {
    public static void main(String[] args) {
        // absolute path
        String filename = "C:\\Users\\user\\Desktop\\TARGET-APR-2023-BATCH-1\\Week-02-Assignment.md";

        // relative (to the current project location) path
        // String filename = "../../../Week-02-Assignment.md";

        File file = new File(filename);

        if (!file.exists()) {
            log.trace("The file '{}' doesn't exist", filename);
            return;
        }

        try (
                FileReader reader = new FileReader(file);
        ) {
            int ch;
            int loopCount = 0;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                loopCount++;
            }
            System.out.println();
            log.trace("The file '{}' was successfully read", filename);
            log.trace("The while loop was executed {} times", loopCount);
        } // this is when reader.close() is called automatically
        catch (FileNotFoundException e) {
            log.warn("There was an error while opening the file '{}' for reading", filename);
        } catch (IOException e) {
            log.warn("There wan an error while reading the file '{}'", filename);
        }
    }
}
