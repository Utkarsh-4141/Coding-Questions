package Tree;

public class HeightOfTree { // O(n) & O(h)
    static int height(Node root) {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        System.out.println("Height of tree: " + height(root));
    }
}

// h=1+max(hleft​,hright​)
// Depth of a node = Distance from root to that node.
// Height of a tree = Longest root-to-leaf path.