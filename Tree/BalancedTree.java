package Tree;

public class BalancedTree { // O(n) & O(h)
    static int height(Node root) {
        if(root == null)
            return 0;
        int left = height(root.left);
        if(left == -1)
            return left;
        int right = height(root.right);
        if(right == -1)
            return right;
        if(Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }

    static boolean isBalanced(Node root) {
        return height(root) != -1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Tree Balanced: " + isBalanced(root));
    }
}

// For Balanced Tree:
// | hleft​ − hright | ≤ 1