package Array;
import java.util.*;

public class KthLargestElement { // O(nlog(k)) & O(k)
    static int findKthLargest(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(); // Kth largest element
        //Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Kth smallest element
        for(int val : arr) {
            minHeap.add(val);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4,5};
        int k = 3;
        System.out.println(k + " largest element: " + findKthLargest(nums, k)); // Output: 5
    }
}
