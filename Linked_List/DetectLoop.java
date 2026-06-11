package Linked_List;

// Floyd's Cycle Detection Algorithm (Tortoise and Hare Algorithm)
public class DetectLoop { // O(n) & O(1)
    Node head;

    public boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.head.next.next.next.next.next = list.head.next;

        if(list.hasLoop(list.head)) {
            System.out.println("Loop Found!");
        } else {
            System.out.println("No Loop");
        }
    }
}

// using HashSet => O(n) & O(n) extra space