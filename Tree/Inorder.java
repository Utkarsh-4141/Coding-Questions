package Tree;

// DFS Traversal (uses Stack)
public class Inorder { // O(n) & O(h)

    static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right.right = new Node(20);

        System.out.println("Inorder Traversal: ");
        inorder(root);
    }
}

// Inorder traversal : left -> root -> right
// Inorder is used for: sorted tree