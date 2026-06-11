package String;

// Palindrome grows from center, not from ends
// Expand around each center and track the longest palindrome
public class LongestPalindromicSubstring { // O(n²) & O(1)
    static String longestPalindrome(String str) {
        if(str==null || str.length()==0)
            return "";
        int start=0, end=0;
        for(int i=0 ; i<str.length() ; i++) {
            int len1 = expand(str, i, i); // odd length
            int len2 = expand(str, i, i+1); // even length
            int len = Math.max(len1, len2);
            if(len > end-start) { // len > previous length
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    static int expand(String str, int left, int right) {
        while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1; // length of palindrome
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
