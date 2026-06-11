package Linked_List;

public class MergeSortLinkedList { // O(n log n) & O(log n)

    static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(left != null && right != null) {
            if(left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left != null)
            tail.next = left;
        if(right != null)
            tail.next = right;
        return dummy.next;
    }

    static Node getMiddle(Node head) {
        if(head == null)
            return head;
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
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
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Before Sorting: ");
        display(head);

        head = mergeSort(head);

        System.out.println("After Sorting: ");
        display(head);
    }
}

// Find Middle
// Recursively Sort Both Halves
// Merge Two Sorted Lists