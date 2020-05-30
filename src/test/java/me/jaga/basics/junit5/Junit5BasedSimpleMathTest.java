package me.jaga.basics.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Execution(ExecutionMode.SAME_THREAD)
public class Junit5BasedSimpleMathTest extends BaseTest{

    @BeforeEach
    public void beforeEachPrint() {
        /*
        * Gets printed for each method. For Paramterized - each param case is treated as a separate invocation
         */
        System.out.println("********Before each of the test case ************");
    }

    @Test
    public void testMath() {
        assertEquals(Calculator.addForPositiveNumbers(2,3),5,"Simple Math test");
    }

    @ParameterizedTest
    @CsvSource({
            "0,1,1",
            "1,2,3",
            "100,455, 555"
    })
    public void testParameterizedAdd(int first, int second, int expectedValue) {
        assertEquals(expectedValue,Calculator.addForPositiveNumbers(first,second),"Computing for value " + first + " + " + second + "+ = " + expectedValue);
    }

    @Test
    public void testExceptions() {
        assertThrows(UnsupportedOperationException.class,()-> Calculator.addForPositiveNumbers(-1,1));
    }
}
