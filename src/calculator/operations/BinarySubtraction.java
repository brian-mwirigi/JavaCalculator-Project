package calculator.operations;

import calculator.abstracts.AbstractBinaryOperation;
import calculator.exceptions.InvalidBinaryNumberException;

public class BinarySubtraction extends AbstractBinaryOperation {
    public String calculate(String num1, String num2) {
        try {
            int n1 = binaryToDecimal(num1);
            int n2 = binaryToDecimal(num2);
            int result = n1 - n2;
            return decimalToBinary(result);
        } catch (InvalidBinaryNumberException e) {
            return "Error";
        }
    }

    public String getName() {
        return "Subtract";
    }
}
