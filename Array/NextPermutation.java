package Array;

import java.util.Arrays;

public class NextPermutation { // Greedy + reverse approach O(n) & O(1)
    static void findNext(int[] arr) {
        int n = arr.length;
        // Step 1: Find first decreasing element from right
        int i = n-2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        // Step 2: If found, swap with just greater element
        if(i>=0) {
            int j = n-1;
            while(arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        // Step 3: Reverse the remaining array of right side
        reverse(arr, i+1, n-1);
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void reverse(int[] arr, int left, int right) {
        while(left<right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findNext(arr);
        System.out.println(Arrays.toString(arr));
    }
}
