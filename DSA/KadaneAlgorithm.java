public class KadaneAlgorithm {
    
    static int maxSubArraySum(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int val : arr) {
            currentSum += val;
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum<0)
                currentSum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        System.out.println("Maximum subarray sum: " + maxSubArraySum(arr));
    }
}
