import java.util.*;

public class LongestSubstring { //Sliding Window O(n) & O(n)

    static int longestSubstring(String str) {
        int left=0, max=0;
        Set<Character> set = new HashSet<>();
        for(int right=0 ; right<str.length() ;  right++) {
            //removes until duplicate exists
            while(set.contains(str.charAt(right))) {
                set.remove(str.charAt(left++));
            }
            //adds unique char
            set.add(str.charAt(right));
            //stores larger length
            max = Math.max(max, right-left+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Length of longest substring: " + longestSubstring(str));
        sc.close();
    }
}
