package Stack;
import java.util.*;

public class NextGreaterElement { // O(n) & O(n)
    static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1 ; i>=0 ; i--) {  // MONOTONIC DECREASING STACK
            while(!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10};

        int[] ans = nextGreater(arr);

        System.out.println("Next Greater Elements:");

        for (int num : ans) {
            System.out.print(num + " ");  // [5, 10, 10, -1]
        }
    }
}
