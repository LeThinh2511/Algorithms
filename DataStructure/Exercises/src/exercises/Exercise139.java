package exercises;

import implementation.StackLinkedListImplementation;

import java.util.Scanner;

/**
 * Author: thinhle
 * Date: 2019-03-06
 */

public class Exercise139 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Expression: ");
        String expression = scanner.nextLine();
        String result = null;
        StackLinkedListImplementation<String> operands = new StackLinkedListImplementation<>();
        StackLinkedListImplementation<String> operators = new StackLinkedListImplementation<>();

        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char character = expression.charAt(i);
            if (character == '+' || character == '-' || character == '*' || character == '/') {
                operators.push("" + character);
            } else if (character == ')') {
                String secondOperand = operands.pop();
                String firstOperand = operands.pop();
                String operator = operators.pop();
                String newOperand = "(" + firstOperand + operator + secondOperand + ")";
                operands.push(newOperand);
            } else if (character != ' ') {
                operands.push("" + character);
                char nextChar = expression.charAt(i + 1);
                while (nextChar != '+' && nextChar != '-' && nextChar != '*' && nextChar != '/' && nextChar != ' ') {
                    String operand = operands.pop() + nextChar;
                    operands.push(operand);
                    nextChar = expression.charAt(++i + 1);
                }
            }
        }
        System.out.println("Results: " + operands.pop());
    }
}
