package com.targetindia.tests.mathutils;

import com.targetindia.utils.MathUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SumTests {

    // JUnit provides lifecycle hooks (methods) to do initialization and clean up activities
    // @BeforeEach, @AfterEach, @BeforeAll, @AfterAll
    MathUtils mu;

    @BeforeAll
    static void theFirstMethod(){
        log.trace("SumTests.theFirstMethod() called");
    }

    @AfterAll
    static void theLastMethod(){
        log.trace("SumTests.theLastMethod() called");
    }

    @BeforeEach
    void initialize(){ // method name can be anything
        log.trace("SumTests.initialize() called");
        mu = new MathUtils();
    }

    @AfterEach
    void cleanup(){ // method name can  be anything
        log.trace("SumTests.cleanup() called");
    }

    @Test
    @DisplayName("Should give correct sum for numeric inputs")
    void shouldGiveCorrectSumForNumericInputs(){
        log.trace("SumTests.shouldGiveCorrectSumForNumericInputs() called");

        double expected = 30;
        double actual = mu.sum("12", "18");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should give zero for no inputs")
    void shouldGiveZeroForNoInputs(){
        log.trace("SumTests.shouldGiveZeroForNoInputs() called");

        assertEquals(0, mu.sum());
    }

    @Test
    @DisplayName("Should give zero for only non-numeric inputs")
    void shouldGiveZeroForOnlyNonNumericInputs(){
        log.trace("SumTests.shouldGiveZeroForOnlyNonNumericInputs() called");

        assertEquals(0, mu.sum("vinod", "ten", "fifty"));
    }

    @Test
    @DisplayName("Should throw an exception when null is passed")
    @Disabled
    void shouldThrowAnExceptionWhenNullIsPassed(){
    }

    @Nested
    @DisplayName("Negative tests")
    class NegativeTests {

        @Test
        @Disabled
        @DisplayName("Should throw Exception for Null input/s")
        void shouldThrowExceptionForNullInputs(){
            // crude way to handle it
            try{
                mu.sum(null);
                // no error; test should fail
                fail("Was expecting NullPointerException; did not get one!");
            }
            catch(NullPointerException e){
                // test passes, nothing to be done!
                return;
            }
            catch(Throwable t){
                fail("Was expecting NullPointerException", t);
            }

        }

        @Test
        @DisplayName("Should throw NullPointerException for Null input/s")
        void shouldThrowNullPointerExceptionForNullInputs(){
            assertThrows(NullPointerException.class, ()->{
                mu.sum("vinod", "123", null);
            });
        }
    }
}
