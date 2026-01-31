package calculator.abstracts;

import calculator.interfaces.BinaryOperation;
import calculator.interfaces.Validatable;
import calculator.exceptions.InvalidBinaryNumberException;

public abstract class AbstractBinaryOperation implements BinaryOperation, Validatable {
    public boolean isValid(String binary) {
        if (binary == null || binary.isEmpty()) {
            return false;
        }
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    protected int binaryToDecimal(String binary) throws InvalidBinaryNumberException {
        if (!isValid(binary)) {
            throw new InvalidBinaryNumberException("Invalid binary number");
        }
        int result = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }
        return result;
    }

    protected String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        String result = "";
        int num = Math.abs(decimal);
        while (num > 0) {
            result = (num % 2) + result;
            num = num / 2;
        }
        if (decimal < 0) {
            result = "-" + result;
        }
        return result;
    }
}
