package Tree;

// Only for BST
public class LCAInBST {
    static Node lca(Node root, int p, int q) {
        // Recursive => O(log n) & O(log n) {O(n) for skewed tree}
        if(root == null)
            return null;
        if(p < root.data && q < root.data)
            return lca(root.left, p, q);
        if(p > root.data && q > root.data)
            return lca(root.right, p, q);
        return root;

        // Iterative => O(log n) & O(1) {No recursion stack, less memory}
        // while(root != null) {
        //     if(p < root.data && q < root.data)
        //         root = root.left;
        //     else if(p > root.data && q > root.data)
        //         root = root.right;
        //     else
        //         return root;
        // }
        // return null;
    }
    
    public static void main(String[] args) {
        Node root = new Node(50);
        
        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Node lca = lca(root, 20, 80);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }
}

// | Approach          | Time | Space |
// | ----------------- | ---- | ----- |
// | Recursive BST LCA | O(h) | O(h)  |
// | Iterative BST LCA | O(h) | O(1)  |

// Balanced BST -> O(h) = O(log n)
// Skewed Tree  -> O(h) = O(n)
