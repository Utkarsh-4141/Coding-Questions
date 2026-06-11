package Linked_List;

// Two Pointer
public class IntersectionPoint { // O(n+m) & O(1)

    static Node findIntersection(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Node p1 = headA;
        Node p2 = headB;
        while(p1 != p2) {  //checks references not the values
            if(p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            if(p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
        }
        return p1;
    }
    
    public static void main(String[] args) {
        Node common = new Node(7);
        common.next = new Node(8);
        common.next.next = new Node(9);

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        Node headB = new Node(4);
        headB.next = new Node(5);
        headB.next.next = common;

        Node intersection = findIntersection(headA, headB);
        
        if(intersection != null) {
            System.out.println("Intersection Node: " + intersection.data);
        } else {
            System.out.println("No Intersection");
        }
    }
}

// Pointer1 travels: a + c + b
// Pointer2 travels: b + c + a