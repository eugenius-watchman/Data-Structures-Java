package eugenius.datastructures.stack;

import java.util.Stack;

public class BracketValidator {

    // Helper method to get bracket reversed
    private static char getReversedBracket(char bracket) {
        switch (bracket) {
            case ')': return '(';
            case '(': return ')';
            case '{': return '}';
            case '}': return '{';
            case '[': return ']';
            case ']': return '[';
            // default: return '\0'; // invalid bracket
            default:
                throw new IllegalArgumentException("Invalid bracket: " + bracket);
        }
    }
    //Helper method to check if bracket is left bracket
    public static boolean isLeftBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    // Method to validate the bracket string
    public static boolean isValidBracketString(String bracketString) {
        Stack<Character> stack = new Stack<>();

        for (char bracket: bracketString.toCharArray()) {
            try {
                char rev = getReversedBracket(bracket);

                if(isLeftBracket(bracket)) {
                    stack.push(bracket);
                } else if (stack.isEmpty() || stack.pop() != rev) {
                    return false; // Invalid
                }

            } catch (IllegalArgumentException e) {
                // If character is not a valid bracket, implies invalid string
                return false;
            }
        }

        return stack.isEmpty(); // Valid

    }
     public static void main(String[] args) {
        String bracketString = "{[()]}";
        boolean isValid = isValidBracketString(bracketString);

        if(isValid) {
            System.out.println("The bracket is a valid string.");
        } else {
            System.out.println("The bracket is an invalid string.");
        }
     }

}
