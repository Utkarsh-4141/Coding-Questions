package Array;

public class MaxProdSubarray { // DP + Greedy O(n) & O(1) modified Kadane
    static int maxProduct(int[] arr) {
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = arr[0];
        for(int i=1 ; i<arr.length ; i++) {
            // If current number is negative → swap
            if(arr[i]<0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(arr[i], maxSoFar*arr[i]);
            minSoFar = Math.min(arr[i], minSoFar*arr[i]);
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product of contiguous subarray: " + maxProduct(nums));
    }
}
