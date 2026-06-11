package String;

// Expand around center
// Substring => contiguous
public class CountPalindrominSubstrings { // O(n^2) & O(1)
    static int countPalindromicSubstrings(String str) {
        int count = 0;
        for(int i=0 ; i<str.length() ; i++) {
            count += expand(str, i, i);
            count += expand(str, i, i+1);
        }
        return count;
    }

    static int expand(String str, int left, int right) {
        int count = 0;
        while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "ababba"; // a b a b b a aba bab abba bb
        System.out.println("Count: " + countPalindromicSubstrings(str));
    }
}
