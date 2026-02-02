package calculator.operations;

import calculator.helpers.MathHelper;
import calculator.exceptions.BadInputError;

public class Multiply extends MathHelper {
    
    public String calculate(String num1, String num2) {
        String answer = "";
        
        try {
            int decimal1 = toDecimal(num1);
            int decimal2 = toDecimal(num2);
            
            int product = 0;
            product = decimal1 * decimal2;
            
            String binaryAnswer = toBinary(product);
            answer = binaryAnswer;
            
        } catch (BadInputError e) {
            answer = "Error";
        }
        
        return answer;
    }

    public String getName() {
        return "Multiply";
    }
}
