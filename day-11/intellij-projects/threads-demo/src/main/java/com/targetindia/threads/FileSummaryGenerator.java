package com.targetindia.threads;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class FileSummaryGenerator extends Thread {

    private String filename;
    private Writer writer;

    public FileSummaryGenerator(String filename, Writer writer) {
        this.filename = filename;
        this.writer = writer;
    }

    @Override
    public void run() {
        // read the file, and generate the summary information about
        // 1. number of lines
        // 2. number of words
        // 3. number of letters
        // along with the filename and the time taken to generate this summary
        int nLines = 0;
        int nWords = 0;
        int nLetters = 0;

        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);

        ) {
            String line;

            while ((line = in.readLine()) != null) {
                nLines++;
                nLetters += line.length() + 1; // +1 for the '\n'
                nWords += line.split("[\s,.]").length;
            }
        } // in and reader gets closed here
        catch (Exception e) {
            log.warn("Error!", e);
        }

        // filename = "HelloWorld.java"
        // outFilename = "HelloWorld_summary_<timestamp>.txt"
        String outFilename = filename.substring(0, filename.lastIndexOf("."))
                + "_summary_"
                + System.currentTimeMillis()
                + ".txt";
        try {
            PrintWriter out = new PrintWriter(writer);
            out.printf("Input filename: %s%n", filename);
            out.printf("Number of lines: %d%n", nLines);
            out.printf("Number of words: %d%n", nWords);
            out.printf("Number of letters: %d%n", nLetters);
            out.println("---------------------------------------------------");
            // do not close the "out", as the output stream needs to be open for other threads to write
        } catch (Exception e) {
            log.warn("Error!", e);
        }
        log.trace("The thread '{}' terminated and the outputfile '{}' created!",
                Thread.currentThread().getName(),
                outFilename);
    }
}
