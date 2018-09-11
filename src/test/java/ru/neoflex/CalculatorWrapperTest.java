package ru.neoflex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class CalculatorWrapperTest {

    private CalculatorWrapper calculatorWrapper;
    private ICalculator iCalculator;
    private Answer<Integer> answer = invocationOnMock -> {
        Object mock = invocationOnMock.getMock();
        System.out.println("mock object : " + mock.toString());

        Object[] args = invocationOnMock.getArguments();
        int d1 = (int) args[0];
        int d2 = (int) args[1];
        int sum = d1 + d2;
        System.out.println("" + d1 + " + " + d2);

        return sum;
    };

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

        when(iCalculator.division(anyInt(), eq(0))).thenThrow(new ArithmeticException());

        calculatorWrapper.division(6, 0);
    }

    @Test
    public void testThenAnswer() {
        when(iCalculator.add(19, 25)).thenAnswer(answer);
        assertEquals(calculatorWrapper.add(19, 25), 44);
    }
}