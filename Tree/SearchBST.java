package Tree;

public class SearchBST { // Recursive => O(log n) & O(h)  {O(n) for skewed BST}
    static boolean search(Node root, int key) {
        if(root == null)
            return false;
        if(key == root.data)
            return true;
        if(key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }
    
    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Search: " + search(root, 60));
    }
}

// Iterative Solution => O(log n) & O(1)  (like binary search)
// static boolean search(Node root, int key) {
//     while(root != null) {
//         if(root.data == key)
//             return true;
//         if(key < root.data)
//             root = root.left;
//         else
//             root = root.right;
//     }
//     return false;
// }