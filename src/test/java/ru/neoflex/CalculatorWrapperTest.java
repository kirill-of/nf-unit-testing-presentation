package ru.neoflex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class CalculatorWrapperTest {

    private CalculatorWrapper calculatorWrapper;
    private ICalculator iCalculator;

    @Before
    public void initTest() {
        iCalculator = mock(ICalculator.class);
        calculatorWrapper = new CalculatorWrapper(iCalculator);
    }

    @After
    public void afterTest() {
        iCalculator = null;
        calculatorWrapper = null;
    }

    @Test
    public void add() {
        when(iCalculator.add(10, 20)).thenReturn(30);

        assertEquals(30, calculatorWrapper.add(10, 20));
    }

    @Test
    public void subtraction() {
        when(iCalculator.subtraction(28, 15)).thenReturn(13);

        assertEquals(13, calculatorWrapper.subtraction(28, 15));
    }

    @Test
    public void division() {
        when(iCalculator.division(26, 2)).thenReturn(13);


        assertEquals(13, calculatorWrapper.division(26, 2));
        assertEquals(13, calculatorWrapper.division(26, 2));

        verify(iCalculator, atLeastOnce()).division(26, 2);
        verify(iCalculator, atLeast(2)).division(26, 2);
        verify(iCalculator, never()).subtraction(anyInt(), anyInt());
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {

        when(iCalculator.division(anyInt(), eq(0))).thenThrow(ArithmeticException.class);

        calculatorWrapper.division(6, 0);
    }
}