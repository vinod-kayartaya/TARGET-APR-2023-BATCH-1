package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j
public class ExceptionDemo {

    static void divideNumbersFromCLI(String[] args){
        log.trace("started the divideNumbersFromCLI() method");
        try {
            String input1 = args[0];
            log.trace("input1 is {}", input1);
            String input2 = args[1];
            log.trace("input2 is {}", input2);
            int num = Integer.parseInt(input1);
            log.trace("numerator is {}", num);
            int den = Integer.parseInt(input2);
            log.trace("denominator is {}", den);
            int quo = num / den;
            log.trace("quotient is {}", quo);
            int rem = num % den;
            log.trace("remainder is {}", rem);
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warn("Expected 2 integers from command line, got {}", args.length);
        } catch (ArithmeticException e) {
            log.warn("Cannot divide an integer by zero!");
            return; // takes the control back to the caller of this function
        } catch (NumberFormatException e) {
            log.warn("Only int arguments were expected");
        } catch (Exception e) {
            log.warn("There was an exception with a message - {}", e.getMessage());
        }
        finally {
            log.trace("doing some cleanup activities in the finally block...");
        }

        log.trace("returning from divideNumbersFromCLI() back to main()");
    }

    public static void main(String[] args) {
        log.trace("started executing main() method");

        divideNumbersFromCLI(args);

        log.trace("finished executing the main() method");
    }
}
