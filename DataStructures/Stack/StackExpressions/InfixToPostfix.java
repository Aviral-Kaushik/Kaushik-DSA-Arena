package DataStructures.Stack.StackExpressions;

import java.util.Stack;

public class InfixToPostfix {

    /// Problem Statement:
    /// In this problem, we have give an infix expression & we need to convert it into it's equivalent postfix expression.
    /// The operations we consider are ^, *, /, + & -, and the operands are from a to z.

    /**
     * Efficient Method (Using Stack)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static String convertInfixToPostfixUsingStack(String infixExpression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (char c: infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfixExpression.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (getPrecedence(c) < getPrecedence(stack.peek()) ||
                       (getPrecedence(c) == getPrecedence(stack.peek()) && !isRightAssociative(c)))) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();
    }

    private static int getPrecedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    private static boolean isRightAssociative(char operator) {
        return operator == '^';
    }

    public static void main(String[] args) {
        String infixExpression1 = "a+b*c"; // abc*+
        String infixExpression2 = "(a+b)*c"; // ab+c*
        String infixExpression3 = "a^b^c"; // abc^^
        String infixExpression4 = "(a+b)*(c+d)"; // ab+cd+*
        String infixExpression5 = "a+b/c-d*e"; // abc/+de*-
        String infixExpression6 = "a+b*(c^d-e)^(f+g*h)-i"; // abcd^e-fgh*+^*+i-

        System.out.println(convertInfixToPostfixUsingStack(infixExpression1));
        System.out.println(convertInfixToPostfixUsingStack(infixExpression2));
        System.out.println(convertInfixToPostfixUsingStack(infixExpression3));
        System.out.println(convertInfixToPostfixUsingStack(infixExpression4));
        System.out.println(convertInfixToPostfixUsingStack(infixExpression5));
        System.out.println(convertInfixToPostfixUsingStack(infixExpression6));
    }

}
