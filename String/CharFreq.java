package String;

import java.util.*;

public class CharFreq { // O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();

        for(char val : str.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0) +1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            // if(entry.getValue() > 1) // Print all duplicates
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sc.close();
    }
}
