package DataStructures.Stack.PracticeProblems;

import DataStructures.Stack.Utils.StringStack;

public class BalancedParenthesis {

    /// Problem Statement:
    /// In this problem, we have given a string with 6 possible characters (, ), {, }, [ & ] and are task to check
    /// whether the given strings contain balanced parenthesis or not. Balanced Parenthesis means for every opening
    /// bracket there should be closing bracket. The parenthesis that is last opened must be closed first before any
    /// other bracket must be closed.

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Where n is the number of characters in the string
     * */
    private static boolean areBalancedParenthesis(String data) {
        StringStack stack = new StringStack();

        for (char c: data.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char element = stack.pop();

                if (!matching(element, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean matching(char a, char b) {
        return ((a == '(' && b == ')') ||
                (a == '{' && b == '}') ||
                (a == '[' && b == ']'));
    }

    public static void main(String[] args) {
        String testCase1 = "([])";
        String testCase2 = "((())";
        String testCase3 = "([)]";
        String testCase4 = "{}([()]}";
        String testCase5 = "(()))";

        System.out.println(areBalancedParenthesis(testCase1));
        System.out.println(areBalancedParenthesis(testCase2));
        System.out.println(areBalancedParenthesis(testCase3));
        System.out.println(areBalancedParenthesis(testCase4));
        System.out.println(areBalancedParenthesis(testCase5));
    }

}
