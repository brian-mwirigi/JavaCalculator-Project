package calculator.operations;

import calculator.abstracts.AbstractBinaryOperation;
import calculator.exceptions.InvalidBinaryNumberException;
import calculator.exceptions.DivisionByZeroException;

public class BinaryDivision extends AbstractBinaryOperation {
    
    public String calculate(String num1, String num2) {
        String answer = "";
        
        try {
            int decimal1 = binaryToDecimal(num1);
            int decimal2 = binaryToDecimal(num2);
            
            if (decimal2 == 0) {
                throw new DivisionByZeroException("Cannot divide by zero");
            }
            
            int quotient = 0;
            quotient = decimal1 / decimal2;
            
            String binaryAnswer = decimalToBinary(quotient);
            answer = binaryAnswer;
            
        } catch (DivisionByZeroException e) {
            answer = "Error: Divide by 0";
        } catch (InvalidBinaryNumberException e) {
            answer = "Error";
        }
        
        return answer;
    }

    public String getName() {
        return "Divide";
    }
}
