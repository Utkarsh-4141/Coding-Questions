package Linked_List;

// Floyd's Cycle Detection Algorithm (Tortoise and Hare Algorithm)
public class DetectLoop { // O(n) & O(1)

    static boolean hasLoop(Node head) {
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
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    head.next.next.next.next.next =head.next;

        if(hasLoop(head)) {
            System.out.println("Loop Found!");
        } else {
            System.out.println("No Loop");
        }
    }
}

// using HashSet => O(n) & O(n) extra space