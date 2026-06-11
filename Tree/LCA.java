package Tree;

// For any binary tree
public class LCA { // O(n) & O(h)
    static Node findLCA(Node root, int p, int q) {
        if(root == null)
            return null;

        // If current node itself is one of the targets, return it.
        if(root.data == p || root.data == q)
            return root;

        // Search Both Sides
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        // Both found, Current node becomes LCA.
        if(left != null && right != null)
            return root;

        // Only Left Found
        if(left != null)
            return left;

        // Only Right Found
        return right;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node lca = findLCA(root, 4, 3);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }
}

// This pattern appears again in:
// LCA
// Distance Between Nodes
// Path Finding Problems
// Tree Burning Problems