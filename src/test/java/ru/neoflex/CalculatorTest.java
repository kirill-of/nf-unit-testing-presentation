package ru.neoflex;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void add() {
        assertEquals(4, calculator.add(2, 2));
        assertTrue(calculator.add(2, 2) == 4);
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    public void subtraction() {
        assertEquals(7, calculator.subtraction(10, 3));
    }

    @Test
    public void multiplication() {
        assertEquals(33, calculator.multiplication(11, 3));
    }

    @Test
    public void division() {
        assertEquals(20, calculator.division(100, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        calculator.division(15, 0);
    }
}