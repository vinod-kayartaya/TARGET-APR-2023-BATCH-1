package com.targetindia.tests;

import com.targetindia.utils.DateUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateUtilsTests {

    @Test
    void shouldReturnFalseForNonLeapYear(){
        DateUtils du;
        du = new DateUtils();

        boolean result = du.isLeap(1999);
        assertFalse(result);
        assertFalse(du.isLeap(2100));
        // assertFalse(du.isLeap(-2100));
    }

    @Test
    void shouldReturnTrueForLeapYear(){

        DateUtils du;
        du = new DateUtils();

        int input = 1996;
        boolean expected = true;
        boolean actual = du.isLeap(input);
        // assertions are functions provided by the JUnit library which check
        // for the working of the function under test, and throw an exception
        // if the assertion fails.
        assertEquals(expected, actual);
        // if expected == actual, then assertion passes (test passed)
        // else throws an AssertionError (test failure)
        assertTrue(du.isLeap(2000));
        assertTrue(du.isLeap(2004));
    }
}
