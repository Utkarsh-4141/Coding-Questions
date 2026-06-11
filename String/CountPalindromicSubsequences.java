package String;

// Dynamic Programming (inclusion-exclusion logic)
// Subsequence => can skip characters
public class CountPalindromicSubsequences { // O(n^2) & O(n^2)
    static int countPS(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        // Single characters
        for(int i=0 ; i<n ; i++) {
            dp[i][i] = 1;
        }

        // 2 to n characters
        for(int len=2 ; len<=n ; len++) {
            for(int i=0 ; i<=n-len ; i++) {
                int j = i+len-1;
                if(str.charAt(j) == str.charAt(i))
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1; // inclusion
                else
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]; // exclusion
            }
        }
        return dp[0][n-1]; // final count
    }
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println("Count: " + countPS(s));
    }
}
