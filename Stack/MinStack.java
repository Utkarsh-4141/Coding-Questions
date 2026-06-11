package Stack;
import java.util.*;

// Two Stacks
public class MinStack { // O(1) retrieval
    Stack<Integer> stack;
    Stack<Integer> minStack;
    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()) {
            minStack.push(val); // stores only smaller value than top value
        }
    }

    int pop() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        int removed = stack.pop();
        if(removed == minStack.peek()) {
            minStack.pop();
        }
        return removed;
    }

    int top() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack.peek();
    }

    int getMin() {
        if(minStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(2);
        ms.push(10);
        ms.push(1);
        // stack => [5,2,10,1]
        // minStack => [5,2,1]

        System.out.println("Minimum: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());

        System.out.println("Minimum: " + ms.getMin());
    }
}
