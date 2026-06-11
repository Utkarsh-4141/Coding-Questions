package Linked_List;

public class ReverseLinkedList { // O(n) & O(1)
    Node head;

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.println("Original list: ");
        list.display(list.head);

        list.head = list.reverse(list.head);
        System.out.println("Reversed list: ");
        list.display(list.head);
    }
}
