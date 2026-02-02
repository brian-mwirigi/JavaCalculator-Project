package calculator.operations;

import calculator.helpers.MathHelper;
import calculator.exceptions.BadInputError;
import calculator.exceptions.DivideByZeroError;

public class Divide extends MathHelper {
    
    public String calculate(String num1, String num2) {
        String answer = "";
        
        try {
            int decimal1 = toDecimal(num1);
            int decimal2 = toDecimal(num2);
            
            if (decimal2 == 0) {
                throw new DivideByZeroError("Cannot divide by zero");
            }
            
            int quotient = 0;
            quotient = decimal1 / decimal2;
            
            String binaryAnswer = toBinary(quotient);
            answer = binaryAnswer;
            
        } catch (DivideByZeroError e) {
            answer = "Error: Divide by 0";
        } catch (BadInputError e) {
            answer = "Error";
        }
        
        return answer;
    }

    public String getName() {
        return "Divide";
    }
}
