package com.targetindia.programs;

import com.targetindia.threads.FileSummaryGenerator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadDemo5 {
    @SneakyThrows
    static void join(Thread t){
        t.join();
    }


    public static void main(String[] args) {
        log.trace("Started the main() method");
        String[] filenames = {
                "src/main/java/com/targetindia/programs/HelloWorld.java",
                "src/main/java/com/targetindia/programs/MethodReferenceDemo.java",
                "src/main/java/com/targetindia/programs/ThreadDemo1.java",
                "src/main/java/com/targetindia/threads/FileSummaryGenerator.java",
                "pom.xml"
        };

        try (
                Writer writer = new FileWriter("summary.txt");
                PrintWriter out = new PrintWriter(writer);
        ) {
            out.println("Summary for the following files: ");
            List<Thread> threads = new ArrayList<>();
            for (String filename : filenames) {
                out.println(filename);
                Thread t1 = new FileSummaryGenerator(filename, writer);
                threads.add(t1);
                t1.start();
            }
            out.println("---------------------------------------------------");

            // do not exit the try-with-resources block, until  all the threads are terminated
            // but, how to do it?
            threads.forEach(ThreadDemo5::join);
            log.trace("All threads have been terminated!");
        } // writer.close() and out.close() called here
        catch (Exception e) {
            log.warn("Error!", e);
        }


        log.trace("the main() method ended now!");
    }
}
