package calculator.abstracts;

import calculator.interfaces.BinaryOperation;
import calculator.interfaces.Validatable;
import calculator.exceptions.InvalidBinaryNumberException;

public abstract class AbstractBinaryOperation implements BinaryOperation, Validatable {
    
    public boolean isValid(String binary) {
        if (binary == null) {
            return false;
        }
        if (binary.isEmpty()) {
            return false;
        }
        if (binary.length() == 0) {
            return false;
        }
        
        boolean valid = true;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '0') {
            } else if (c == '1') {
            } else {
                valid = false;
            }
        }
        return valid;
    }

    protected int binaryToDecimal(String binary) throws InvalidBinaryNumberException {
        boolean check = isValid(binary);
        if (check == false) {
            throw new InvalidBinaryNumberException("Invalid binary number");
        }
        
        int decimal = 0;
        int length = binary.length();
        
        for (int i = 0; i < length; i++) {
            int position = length - 1 - i;
            char c = binary.charAt(position);
            
            if (c == '1') {
                int power = 1;
                for (int j = 0; j < i; j++) {
                    power = power * 2;
                }
                decimal = decimal + power;
            }
        }
        
        return decimal;
    }

    protected String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        boolean isNegative = false;
        int num = decimal;
        if (decimal < 0) {
            isNegative = true;
            num = decimal * -1;
        }
        
        String binary = "";
        while (num > 0) {
            int remainder = num % 2;
            if (remainder == 0) {
                binary = "0" + binary;
            } else {
                binary = "1" + binary;
            }
            num = num / 2;
        }
        
        if (isNegative == true) {
            binary = "-" + binary;
        }
        
        return binary;
    }
}
