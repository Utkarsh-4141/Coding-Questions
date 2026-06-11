package Queue;
import java.util.*;

public class StackUsingQueue {
    Queue<Integer> queue;
    StackUsingQueue() {
        queue = new LinkedList<>();
    }

    // Time Complexity = O(n)
    void push(int val) {
        // Step 1: Add new element
        queue.add(val);
        int size = queue.size();
        // Step 2: Rotate previous elements
        for(int i=0 ; i<size-1 ; i++) {
            queue.add(queue.remove());
        }
    }

    // Time Complexity = O(1)
    int pop() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue.remove();
    }

    // Time Complexity = O(1)
    int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue.peek();
    }

    void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for(int val : queue) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }
    public static void main(String[] args) {

        StackUsingQueue s = new StackUsingQueue();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top Element: " + s.peek());

        System.out.println("Removed: " + s.pop());

        s.display();

        s.push(40);

        s.display();
    }
}
