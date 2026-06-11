package Stack;
import java.util.*;

public class InfixToPostFix { // O(n)
    static int precedence(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<exp.length() ; i++) {
            char ch = exp.charAt(i);
            // operand
            if(Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String exp = "A+B*C";

        System.out.println("Postfix Expression: "
                + infixToPostfix(exp));
    }
}
