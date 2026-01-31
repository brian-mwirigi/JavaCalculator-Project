package calculator.core;

import calculator.operations.*;

public class BinaryCalculator {
    private BinaryAddition addition;
    private BinarySubtraction subtraction;
    private BinaryMultiplication multiplication;
    private BinaryDivision division;

    public BinaryCalculator() {
        addition = new BinaryAddition();
        subtraction = new BinarySubtraction();
        multiplication = new BinaryMultiplication();
        division = new BinaryDivision();
    }

    public String calculate(String num1, String num2, String operation) {
        if (operation.equals("+")) {
            return addition.calculate(num1, num2);
        } else if (operation.equals("-")) {
            return subtraction.calculate(num1, num2);
        } else if (operation.equals("*")) {
            return multiplication.calculate(num1, num2);
        } else if (operation.equals("/")) {
            return division.calculate(num1, num2);
        } else {
            return "Error";
        }
    }
}
