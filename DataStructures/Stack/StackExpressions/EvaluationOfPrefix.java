package DataStructures.Stack.StackExpressions;

import java.util.Stack;

public class EvaluationOfPrefix {

    /// Problem Statement:
    /// In this problem, we have given a postfix expression and our task is to evaluate the final result of the
    /// expression. The postfix expression will contain integers and operators and all the tokens are separated by spaces.

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int evaluatePrefixExpression(String[] infixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = infixExpression.length - 1; i >= 0; i--) {
            String currentCharacter = infixExpression[i];

            if (isNumber(currentCharacter)) {
                stack.push(Integer.parseInt(currentCharacter));
            } else {
                Integer operand1 = stack.pop();
                Integer operand2 = stack.pop();

                switch (currentCharacter) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }

        }

        return stack.pop();
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] prefixExpression1 = {"+","2","3"}; // 5
        String[] prefixExpression2 = {"*", "+", "2", "3", "4"}; // 20
        String[] prefixExpression3 = {"-", "*", "+", "5", "6", "7", "8"}; // 69
        String[] prefixExpression4 = {"/", "10", "2"}; // 5
        String[] prefixExpression5 = {"^", "2", "3"}; // 8
        String[] prefixExpression6 = {"^", "2", "^", "3", "2"}; // 512
        String[] prefixExpression7 = {"*", "-5", "3"}; // -15
        String[] prefixExpression8 = {"42"}; // 42
        String[] prefixExpression9 = {"-", "+", "*", "2", "3", "/", "10", "2", "5"}; // 6
        String[] prefixExpression10 = {"/", "7", "3"}; // 2

        System.out.println(evaluatePrefixExpression(prefixExpression1));
        System.out.println(evaluatePrefixExpression(prefixExpression2));
        System.out.println(evaluatePrefixExpression(prefixExpression3));
        System.out.println(evaluatePrefixExpression(prefixExpression4));
        System.out.println(evaluatePrefixExpression(prefixExpression5));
        System.out.println(evaluatePrefixExpression(prefixExpression6));
        System.out.println(evaluatePrefixExpression(prefixExpression7));
        System.out.println(evaluatePrefixExpression(prefixExpression8));
        System.out.println(evaluatePrefixExpression(prefixExpression9));
        System.out.println(evaluatePrefixExpression(prefixExpression10));
    }

}
