package Linked_List;

public class RemoveDuplicates { // O(n) & O(1)

    static Node remove(Node head) {
        Node current = head;
        while(current!=null && current.next!=null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        System.out.println("Original list: ");
        display(head);

        head = remove(head);

        System.out.println("After removing duplicates: ");
        display(head);
    }
}

// What if the list is unsorted? => HashSet