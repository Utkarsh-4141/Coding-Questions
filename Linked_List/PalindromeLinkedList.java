package Linked_List;

// Slow & Fast Pointer
public class PalindromeLinkedList { // O(n) & O(1)

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while(current!=null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static boolean isPalindrome(Node head) {
        if(head==null || head.next==null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node firstHalf = head;
        Node secondHalf = reverse(slow);
        while(secondHalf != null) {
            if(firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        if(isPalindrome(head)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}

// Slow & Fast Pointer → Find middle
// Reverse second half
// Compare first and second halves

// Middle = 3
// | First Half | Second Half |
// | ---------- | ----------- |
// | 1          | 1           |
// | 2          | 2           |
// | 3          | 3           |
