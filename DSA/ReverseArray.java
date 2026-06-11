import java.util.*;

public class ReverseArray { //Two Pointers

    static void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    static void reverse(int[] arr, int start, int end) {
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 5); //rotate array at given position
        System.out.println(Arrays.toString(arr));
    }
}
