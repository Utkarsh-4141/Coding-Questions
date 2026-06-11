package Linked_List;

public class DeleteNodeWithoutHead { // O(1) & O(1)

    static void deleteNode(Node node) {
        if(node == null || node.next == null) 
            return;
        node.data = node.next.data;
        node.next = node.next.next;
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
        head.next = new Node(2);
        Node nodeToDelete = new Node(3);
        head.next.next = nodeToDelete;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Before Deletion: ");
        display(head);

        deleteNode(nodeToDelete);

        System.out.println("After Deletion: ");
        display(head);
    }
}


// Copy Next Data -> Skip Next Node
// For last node -> No next node exists to copy from, Hence deletion is impossible.