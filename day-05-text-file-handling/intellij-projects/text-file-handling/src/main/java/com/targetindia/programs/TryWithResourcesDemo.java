package com.targetindia.programs;

import com.targetindia.service.TestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryWithResourcesDemo {
    public static void main(String[] args) {
        log.trace("start of TryWithResourcesDemo.main()");


        try (
                TestService ts = new TestService();
                // ts is an AutoCloseable object
        ) {
            ts.doSomething(args.length + 1);
            log.trace("this is the last line of try block");
        } // ts.close() called here
        catch (Exception e) {
            log.trace("Got an exception - {}", e.getMessage());
        }
        log.trace("this is the first line after the try block");
        log.trace("end of TryWithResourcesDemo.main()");
    }
}
