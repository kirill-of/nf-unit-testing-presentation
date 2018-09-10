package ru.neoflex;


import org.junit.*;
import static org.junit.Assert.*;


public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @After
    public void afterTest() {
        calculator = null;
    }

    @Test
    public void getSum() {
        assertEquals(4, calculator.getSum(2, 2));
        assertTrue(calculator.getSum(2, 2) == 4);
        assertFalse(calculator.getSum(2, 2) == 5);
    }

    @Test
    public void getDivide() {
        assertEquals(20, calculator.getDivide(100, 5));
    }

    @Test
    public void getMultiple() {
        assertEquals(33, calculator.getMultiple(11, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        calculator.getDivide(15, 0);
    }
}