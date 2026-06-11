package Tree;

// DFS Traversal (uses Stack)
public class Preorder { // O(n) & O(h)

    static void preorder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right.right = new Node(20);

        System.out.println("Preorder Traversal: ");
        preorder(root);
    }
}

// Preorder Traversal : root -> left -> right

// Preorder is used for:
// 1. Copying a Tree

// 2. Creating Expression Trees
// Compilers often use preorder traversal.

// 3. Serialization of Trees
// Saving tree structure to a file/database.