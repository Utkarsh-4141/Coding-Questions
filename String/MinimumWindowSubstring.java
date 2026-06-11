package String;
import java.util.*;

// Sliding Window + Frequency Map
// Expand window to include all required characters, then shrink it to get the minimum valid substring.
public class MinimumWindowSubstring { // O(n) & O(k)
    static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        Map<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }

        int left=0, right=0;
        int formed = 0;
        int required = need.size();
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> window = new HashMap<>();

        while(right < s.length()) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);
            if(need.containsKey(ch) && window.getOrDefault(ch, 0).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            // Try shrinking
            while(left<=right && formed == required) {
                if((right-left+1) < minLength) {
                    minLength = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start+minLength);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // BANC
    }
}
