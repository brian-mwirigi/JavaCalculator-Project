package calculator.operations;

import calculator.abstracts.AbstractBinaryOperation;
import calculator.exceptions.InvalidBinaryNumberException;
import calculator.exceptions.DivisionByZeroException;

public class BinaryDivision extends AbstractBinaryOperation {
    public String calculate(String num1, String num2) {
        try {
            int n1 = binaryToDecimal(num1);
            int n2 = binaryToDecimal(num2);
            if (n2 == 0) {
                throw new DivisionByZeroException("Cannot divide by zero");
            }
            int result = n1 / n2;
            return decimalToBinary(result);
        } catch (DivisionByZeroException e) {
            return "Error: Divide by 0";
        } catch (InvalidBinaryNumberException e) {
            return "Error";
        }
    }

    public String getName() {
        return "Divide";
    }
}
