package Stack;

public class StackUsingArray {
    int[] arr;
    int top;
    int capacity;
    
    StackUsingArray(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    void push(int val) {
        if(top == capacity-1) {
            System.out.println("Stack overflow!");
            return;
        }
        arr[++top] = val;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top+1;
    }

    void display() {
        if(isEmpty()) {
            System.out.println("Stack underflow!");
            return;
        }
        System.out.println("Stack elements: ");
        for(int i=top ; i>=0 ; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Size: " + stack.size());

        System.out.println("Is Empty: " + stack.isEmpty());

        stack.display();
    }
}
