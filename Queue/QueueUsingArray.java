package Queue;

public class QueueUsingArray {
    int[] arr;
    int capacity;
    int rear;
    int front;
    QueueUsingArray(int size) {
        capacity = size;
        arr = new int[capacity];
        rear = -1;
        front = -1;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int val) {
        if(isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        if(front == -1) {
            front = 0;
        }
        arr[++rear] = val;
    }

    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int removed = arr[front];
        if(front == rear) {
            rear = -1;
            front = -1;
        } else {
            front++;
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
        for(int i=front ; i<=rear ; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {

        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Front Element: " + q.peek());

        System.out.println("Removed: " + q.dequeue());

        q.display();

        q.enqueue(40);
        q.enqueue(50);

        q.display();
    }
}
