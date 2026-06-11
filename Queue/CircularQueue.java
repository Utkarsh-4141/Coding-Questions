package Queue;

public class CircularQueue {
    int[] arr;
    int capacity;
    int front;
    int rear;
    CircularQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    void enqueue(int val) {
        if(isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        if(front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = val;
    }

    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int removed = arr[front];
        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return removed;
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        return arr[front];
    }

    void display() {
        if(isEmpty()) {
            System.out.println("Queue Underflow!");
            return;
        }
        int i = front;
        while(true) {
            System.out.println(arr[i]);
            if(i == rear) {
                break;
            }
            i = (i + 1) % capacity;
        }
    }
    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.display();

        q.enqueue(60);
        q.enqueue(70);

        q.display();

        System.out.println("Front Element: " + q.peek());
    }
}

// Linear Queue => Space Wastage
// Circular Queue => No Space Wastage