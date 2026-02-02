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
        String answer = "";
        
        if (operation.equals("+")) {
            
            answer = addition.calculate(num1, num2);
        }
        else if (operation.equals("-")) {
            answer = subtraction.calculate(num1, num2);
            answer = subtraction.calculate(num1, num2);
        }
        else if (operation.equals("*")) {
            
            answer = multiplication.calculate(num1, num2);
        }
        else if (operation.equals("/")) {
            
            answer = division.calculate(num1, num2);
        }
        else if (operation.equals("%")) {
 
            try {
                
                int decimal1 = Integer.parseInt(num1, 2);
                int decimal2 = Integer.parseInt(num2, 2);
                
                
                if (decimal2 == 0) {
                    answer = "Error: Divide by 0";
                } else {
                
                    int remainder = decimal1 % decimal2;
                    
                    answer = Integer.toBinaryString(remainder);
                }
            } catch (Exception e) {
                answer = "Error";
            }
        }
        else {
            
            answer = "Error";
        }
        
        return answer;
    }
}
