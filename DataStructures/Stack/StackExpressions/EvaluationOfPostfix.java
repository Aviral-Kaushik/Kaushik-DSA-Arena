package DataStructures.Stack.StackExpressions;

import java.util.Stack;

public class EvaluationOfPostfix {

    /// Problem Statement:
    /// In this problem, we have given a postfix expression and our task is to evaluate the final result of the
    /// expression. The postfix expression will contain integers and operators and all the tokens are separated by spaces.

    /**
     * Efficient Method (Using Stack)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int evaluatePostfixExpression(String[] postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (String s: postfixExpression) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer operand2 = stack.pop();
                Integer operand1 = stack.pop();

                switch (s) {
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
                        stack.push((int) Math.floor(Math.pow(operand1, operand2)));
                        break;
                }
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] postfixExpression1 = {"2", "3", "+"}; // 2 + 3 = 5
        String[] postfixExpression2 = {"2", "3", "+", "4", "*"}; //  (2 + 3) * 4 = 5 * 4 = 20
        String[] postfixExpression3 = {"4", "13", "5", "/", "+"}; // 13 / 5 = 2 → 4 + 2 = 6
        String[] postfixExpression4 = {"10", "6", "9", "3", "/", "-", "*"}; // 9 / 3 = 3 → 6 - 3 = 3 → 10 * 3 = 30
        String[] postfixExpression5 = {"5", "1", "2", "+", "4", "*", "+", "3", "-"}; // 14
        String[] postfixExpression6 = {"4", "-2", "/", "2", "-3", "-", "*"}; // 10
        String[] postfixExpression7 = {"42"}; // 42
        String[] postfixExpression8 = {"7", "3", "/"}; // 7 / 3 = 2

        System.out.println(evaluatePostfixExpression(postfixExpression1));
        System.out.println(evaluatePostfixExpression(postfixExpression2));
        System.out.println(evaluatePostfixExpression(postfixExpression3));
        System.out.println(evaluatePostfixExpression(postfixExpression4));
        System.out.println(evaluatePostfixExpression(postfixExpression5));
        System.out.println(evaluatePostfixExpression(postfixExpression6));
        System.out.println(evaluatePostfixExpression(postfixExpression7));
        System.out.println(evaluatePostfixExpression(postfixExpression8));
    }

}
