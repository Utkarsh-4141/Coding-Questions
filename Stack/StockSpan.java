package Stack;
import java.util.*;

// Number of consecutive days before it (including current day)
// for which stock price was less than or equal to today’s price.
public class StockSpan { // Monotonic Decreasing Stack   O(n)
    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>(); // stores index not values
        int[] span = new int[n];
        stack.push(0);
        span[0] = 1; // 1st day's span is always 0

        // Traverse remaining days
        for(int i=1 ; i<n ; i++) {
            // Remove smaller or equal prices
            while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]) {
                stack.pop();
            }
            // If stack becomes empty
            if(stack.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - stack.peek();
            }
            // Push current index
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = calculateSpan(prices);

        System.out.println("Stock Span:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
