package Stack;

import java.util.Stack;

public class NextWarmerTemperature { // O(n)
    static int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1 ; i>=0 ; i--) {  // MONOTONIC DECREASING STACK
            while(!stack.isEmpty() && temps[stack.peek()]<=temps[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
    public static void main(String[] args) {

        int[] temps = {73,74,75,71,69,72,76,73};

        int[] ans = dailyTemperatures(temps);

        System.out.println("Days to wait:");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}

// Important Pattern Recognition
// Whenever question says:
// next greater
// future warmer
// next larger
// nearest greater on right

// Think:
// MONOTONIC DECREASING STACK