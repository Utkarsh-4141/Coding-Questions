package Linked_List;

// Two Pointer Technique
public class RemoveNthFromEnd  { // O(n) & O(1)

    public static Node removeNode(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        for(int i=0 ; i<=n ; i++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list: ");
        display(head);

        head = removeNode(head, 2);

        System.out.println("List after removal: ");
        display(head);
    }
}

// Move first pointer N steps ahead.
// Then move both pointers one step at a time.
// When first reaches the last node: second will be just before the node to be deleted.

// Dummy Node => Handles edge cases like: Delete Head Node