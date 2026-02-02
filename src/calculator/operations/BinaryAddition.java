package calculator.operations;

import calculator.abstracts.AbstractBinaryOperation;
import calculator.exceptions.InvalidBinaryNumberException;

public class BinaryAddition extends AbstractBinaryOperation {
    
    public String calculate(String num1, String num2) {
        String answer = "";
        
        try {
            int decimal1 = binaryToDecimal(num1);
            int decimal2 = binaryToDecimal(num2);
            
            int sum = 0;
            sum = decimal1 + decimal2;
            
            String binaryAnswer = decimalToBinary(sum);
            answer = binaryAnswer;
            
        } catch (InvalidBinaryNumberException e) {
            answer = "Error";
        }
        
        return answer;
    }

    public String getName() {
        return "Add";
    }
}
