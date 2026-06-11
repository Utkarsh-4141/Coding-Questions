package Stack;
import java.util.*;

// Monotonic Decreasing Stack
public class RainWaterTrapping { // O(n)
    static int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for(int i=0 ; i<n ; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int leftBoundary = stack.peek();
                int width = i - leftBoundary - 1;
                int boundedHeight = Math.min(height[i], height[leftBoundary]) - height[bottom];
                water += width * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }
    public static void main(String[] args) {

        int[] arr = {4,2,0,3,2,5};

        System.out.println("Trapped Water: "
                            + trap(arr));
    }
}

// Pattern Recognition
// Whenever question says:
// nearest greater boundaries
// trapped region
// valley/container
// bounded area

// Think:
// MONOTONIC STACK