package ru.neoflex;

public class CalculatorWrapper {

    private ICalculator iCalculator;

    public CalculatorWrapper(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int add(int x, int y) {

        //additional functionality
        System.out.println("add");

        return iCalculator.add(x, y);
    }

    public int subtraction(int x, int y) {

        //additional functionality
        System.out.println("subtraction");

        return iCalculator.subtraction(x, y);
    }

    public int division(int x, int y) {

        //additional functionality
        System.out.println("division");

        return iCalculator.division(x, y);
    }


}
