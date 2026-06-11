package Tree;

public class CountNodes { // O(n) & O(h)
    static int countNodes(Node root) {
        if(root == null)
            return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Total Nodes: " + countNodes(root));
    }
}

// leftAnswer = solve(left);
// rightAnswer = solve(right);
// return leftAnswer + rightAnswer + currentContribution;

// This exact pattern is used in:
// Count Nodes
// Sum of Nodes
// Count Leaf Nodes
// Count Even Nodes
// Count Nodes Greater Than X
// Tree Diameter (optimized version)
