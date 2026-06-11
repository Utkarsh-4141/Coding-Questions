package Stack;
import java.util.*;

public class LargestRectangleHistogram { // O(n)
    static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0 ; i<=n ; i++) {  // MONOTONIC INCREASING STACK
            int currentHeight = (i==n) ? 0 : heights[i];
            // Maintain increasing stack
            while(!stack.isEmpty() && currentHeight<heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i-stack.peek()-1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};

        int result = largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area: " + result);
    }
}
