package Queue;
import java.util.*;

// costly dequeue approach (enqueue must be efficient in real world)
public class QueueUsingStack {
    Stack<Integer> stack1; // rear
    Stack<Integer> stack2; // front
    QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Time Complexity = O(1)
    void enqueue(int val) {
        stack1.push(val);
    }

    // Time Complexity = O(n)
    int dequeue() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        // Transfer elements if stack2 empty
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Time Complexity = O(n)
    int peek() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    void display() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();

        // Copy stack2
        temp2.addAll(stack2);
        // Display stack2 elements
        while(!temp2.isEmpty()) {
            System.out.print(temp2.pop() + " ");
        }
        System.out.println();

        // Reverse stack1 for display
        temp1.addAll(stack1);
        Stack<Integer> reverse = new Stack<>();
        while(!temp1.isEmpty()) {
            reverse.push(temp1.pop());
        }
        while(!reverse.isEmpty()) {
            System.out.print(reverse.pop() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Removed: " + q.dequeue());

        System.out.print("Queue: ");
        q.display();

        q.enqueue(40);
        q.enqueue(50);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Front Element: " + q.peek());
        System.out.println("Removed: " + q.dequeue());
        System.out.print("Queue: ");
        q.display();
    }
}
