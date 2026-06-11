package Linked_List;

public class MergeSortedLists { // O(n+m) & O(1)

    static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(list1!=null && list2!=null) {
            if(list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null) {
            tail.next = list1;
        }
        if(list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(7);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);

        Node merged = merge(list1, list2);

        System.out.println("Merged sorted list: ");
        display(merged);
    }
}


// Since both lists are already sorted:
    // Compare the current nodes of both lists.
    // Smaller node goes into the answer.
    // Move that pointer forward.
    // Repeat until one list becomes empty.
    // Finally attach the remaining nodes.