package Linked_List;

// Slow-Fast Pointers
public class FindMiddleNode { // O(n) & O(1)
    Node head;

    public int findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public static void main(String[] args) {
        FindMiddleNode list = new FindMiddleNode();
        
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);

        System.out.println("Middle Node : " + list.findMiddle(list.head));
    }
}
