package Array;
import java.util.*;

public class LongestSubArrayDivByK {
    static int find(int[] arr, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int n = arr.length;
        int sum=0, res=0;
        for(int i=0 ; i<n ; i++) {
            sum = ((sum + arr[i]) % k + k) % k; // handle -ve prefix sum
            if(sum==0)
                res = i +1 ;
            else if(prefixSum.containsKey(sum))
                res = Math.max(res, i - prefixSum.get(sum)); // update length
            else
                prefixSum.put(sum, i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println("Length of longest subarray with sum divisible by " + k + ": " + find(arr, k));
    }
}
