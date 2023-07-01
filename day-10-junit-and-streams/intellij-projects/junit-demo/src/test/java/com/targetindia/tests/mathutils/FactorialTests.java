package com.targetindia.tests.mathutils;

import com.targetindia.utils.InvalidValueException;
import com.targetindia.utils.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTests {

    MathUtils mu;

    @BeforeEach
    void setup() {
        mu = new MathUtils();
    }

    @Test
    @DisplayName("Should return 120 for 5")
    void shouldReturnFactorial() {
        long expected = 120;
        long actual = mu.factorial(5);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6", "4, 24", "5, 120", "6, 720", "7, 5040"})
    void shouldGetFactorialForInput(int input, long expected) {
        long actual = mu.factorial(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/numbers.csv"})
    void shouldCheckFactorialUsingCsvFile(int input, long expected) {
        long actual = mu.factorial(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    // @ValueSource(ints = {-5, -20, -100, -44})
    @CsvFileSource(files = {"nums.csv"})
    void shouldThrowExceptionForNegativeInputs(int input) {
        assertThrows(InvalidValueException.class, () -> mu.factorial(input));
    }
}
