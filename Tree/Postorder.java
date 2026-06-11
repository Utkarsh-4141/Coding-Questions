package Tree;

// DFS Traversal (uses Stack)
public class Postorder { // O(n) & O(h)

    static void postorder(Node root) {
        if(root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right.right = new Node(20);

        System.out.println("Postorder Traversal: ");
        postorder(root);
    }
}

// Postorder Traversal : left -> right -> root

// Postorder is used for:
// 1. Delete a Tree
// Children must be deleted before the parent.

// 2. Evaluating mathematical expressions.
// 5 2 3 * +

// 3. Directory/File Deletion
// Operating systems often delete files inside folders before deleting the folder itself.