package com.targetindia.programs;

import com.targetindia.model.Customer;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

@Slf4j
public class ReadLineByLine {
    public static void main(String[] args) {
        String filename = "customers.csv";

        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line;
            int loopCount = 0;
            in.readLine(); // skip the header

            while ((line = in.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    Customer c = new Customer();
                    c.setId(Integer.parseInt(data[0]));
                    c.setFirstname(data[1]);
                    c.setLastname(data[2]);
                    c.setGender(data[3]);
                    c.setEmail(data[4]);
                    c.setPhone(data[5]);
                    c.setCity(data[6]);

                    System.out.println(c);
                } catch (NumberFormatException e) {
                    log.warn("Got an error while converting '{}' into a Customer object", line);
                }
                loopCount++;
            }
            log.trace("loop count = {}", loopCount);
        } catch (Exception e) {
            log.error("There was an error", e);
        }
    }
}
