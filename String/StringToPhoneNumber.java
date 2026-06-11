package String;
//import java.util.*;

public class StringToPhoneNumber { // Direct Mapping O(n)
    static String[] keypad = {
        "0",    // 0
        "",     // 1
        "ABC",  // 2
        "DEF",  // 3
        "GHI",  // 4
        "JKL",  // 5
        "MNO",  // 6
        "PQRS", // 7
        "TUV",  // 8
        "WXYZ"  // 9
    };
    static String convert(String str) {
        // Map<Character, String> keypad = new HashMap<>(); // Reduces lookup to O(1)
        // keypad.put('A', "2"); keypad.put('B', "22"); keypad.put('C', "222");
        // keypad.put('D', "3"); keypad.put('E', "33"); keypad.put('F', "333");
        // keypad.put('G', "4"); keypad.put('H', "44"); keypad.put('I', "444");
        // keypad.put('J', "5"); keypad.put('K', "55"); keypad.put('L', "555");
        // keypad.put('M', "6"); keypad.put('N', "66"); keypad.put('O', "666");
        // keypad.put('P', "7"); keypad.put('Q', "77"); keypad.put('R', "777"); keypad.put('S', "7777");
        // keypad.put('T', "8"); keypad.put('U', "88"); keypad.put('V', "888");
        // keypad.put('W', "9"); keypad.put('X', "99"); keypad.put('Y', "999"); keypad.put('Z', "9999");
        // numbers.append(keypad.get(ch));
        StringBuilder numbers = new StringBuilder();
        for(char ch : str.toUpperCase().toCharArray()) { // n time
            if(ch == ' ') {
                numbers.append("0");
                continue;
            }
            for(int i=2 ; i<=9 ; i++) { // constant time (8)
                String letters = keypad[i];
                int index = letters.indexOf(ch);
                if(index != -1) {
                    for(int j=0 ; j<=index ; j++) { // constant time
                        numbers.append(i);
                    }
                }
            }
        }
        return numbers.toString();
    }
    public static void main(String[] args) {
        String input = "HELLO";
        System.out.println(convert(input));
    }
}
