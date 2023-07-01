package com.targetindia.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MathUtils {

    public long factorial(int num) {
        if (num < 0) {
            throw new InvalidValueException("factorial of negative numbers cannot be calculated");
        }
        long f = 1;
        while (num > 1) {
            f *= num--;
        }
        return f;
    }

    public double sum(String... args) {
        // if you used String[] args as parameter:
        // double total = MathUtils.sum(new String[]{"12", "1.2", "vinod", "false"});

        // if you used String...args as parameter:
        // double total = MathUtils.sum("12", "1.2", "vinod", "false", "222", "3as");
        // args inside this function is still an array of String
        double total = 0;
        for (String arg : args) {
            try {
                total += Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                log.trace("MathUtils.sum received a non numeric argument {}", arg);
            }
        }

        return total;
    }
}
