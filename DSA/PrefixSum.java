import java.util.*;

public class PrefixSum {
    static int countSubarraysWithSumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0, count=0;
        for(int val : arr) {
            sum += val;
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println("Count subarrays with sum k: " + countSubarraysWithSumK(arr, 2)); // subarray sum(k)=2 [1, 1] & [1, 1] => count=2
    }
}
