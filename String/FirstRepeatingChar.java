package String;

import java.util.*;

public class FirstRepeatingChar { 
    static char findChar(String str) {
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return '\0';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("First repeating char: " + findChar(str));
        sc.close();
    }
}

