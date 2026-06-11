package String;

// Window Size - Max Frequency ≤ k
public class LongRepeatCharReplace { // sliding window O(n)
    static int characterReplacement(String str, int k) {
        int[] freq = new int[26];
        int left=0, maxCount=0, maxLength=0;
        for(int right=0 ; right<str.length() ; right++) {
            char ch = str.charAt(right);
            freq[ch - 'A']++;
            // Track max frequency in window
            maxCount = Math.max(maxCount, freq[ch - 'A']);

            // If invalid window → shrink
            while(((right-left+1) - maxCount) > k) {
                freq[str.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Output: " + characterReplacement(s, k)); // AAAA
    }
}
