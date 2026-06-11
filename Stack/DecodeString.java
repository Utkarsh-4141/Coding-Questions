package Stack;
import java.util.*;

public class DecodeString { // O(n * k) & O(n)
    static String decodeString(String str) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch : str.toCharArray()) {
            // If digit
            if(Character.isDigit(ch)) {
                k = k * 10 + (ch-'0');
            } else if(ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if(ch == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for(int i=0 ; i<repeat ; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else { // Character
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
    public static void main(String[] args) {

        String s = "3[a2[c]]";

        System.out.println("Decoded String: "
                            + decodeString(s));
    }
}

// Pattern Recognition
// Whenever question says:
// nested strings
// recursive pattern
// brackets with repetition
// parsing encoded data

// Think:
// STACK