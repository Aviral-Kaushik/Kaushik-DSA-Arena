package DataStructures.Stack.StackExpressions;

import java.util.Stack;

public class InfixToPrefix {

    /// Problem Statement:
    /// In this problem, we have give an infix expression & we need to convert it into it's equivalent prefix expression.
    /// The operations we consider are ^, *, /, + & -, and the operands are from a to z.

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static String convertInfixToPrefix(String infixExpression) {
        StringBuilder prefixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        infixExpression = reverseInfixExpressionForPrefixConversion(infixExpression);

        for (char c: infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                prefixExpression.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    prefixExpression.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (
                        getPrecedence(c) < getPrecedence(stack.peek()) ||
                                (getPrecedence(c) == getPrecedence(stack.peek()) && isRightAssociative(c))  // flip!
                )) {
                    prefixExpression.append(stack.pop());
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefixExpression.append(stack.pop());
        }

        return prefixExpression.reverse().toString();
    }

    private static String reverseInfixExpressionForPrefixConversion(String infixExpression) {
        infixExpression = new StringBuilder(infixExpression).reverse().toString();

        char[] characters = infixExpression.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '(') {
                characters[i] = ')';
            } else if (characters[i] == ')') {
                characters[i] = '(';
            }
        }

        return new String(characters);
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
        String infixExpression1 = "x+y*z"; // +x*yz
        String infixExpression2 = "(x+y)*z"; // *+xyz
        String infixExpression3 = "x^y^z"; // ^x^yz
        String infixExpression4 = "(x+y)*(z+w)"; // *+xy+zw
        String infixExpression5 = "(a-b/c)*(a/k-l)"; // *-a/bc-/akl
        String infixExpression6 = "x+y*(z-w)"; //+x*y-zw
        String infixExpression7 = "x+y*z/w+u"; // ++x/*yzwu

        System.out.println(convertInfixToPrefix(infixExpression1));
        System.out.println(convertInfixToPrefix(infixExpression2));
        System.out.println(convertInfixToPrefix(infixExpression3));
        System.out.println(convertInfixToPrefix(infixExpression4));
        System.out.println(convertInfixToPrefix(infixExpression5));
        System.out.println(convertInfixToPrefix(infixExpression6));
        System.out.println(convertInfixToPrefix(infixExpression7));
    }

}
