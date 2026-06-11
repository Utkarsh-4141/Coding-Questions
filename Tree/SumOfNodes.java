package Tree;

public class SumOfNodes { // O(n) & O(h)
    static int sum(Node root) {
        if(root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(7);

        System.out.println("Sum of nodes: " + sum(root));
    }
}

// Sum of Leaf Nodes Only:
// int curr = 0;
// if(root.left == null && root.right == null)
//     curr = root.data;
// return sumLeaf(root.left) + sumLeaf(root.right) + curr;

// Sum of Even Nodes:
// int curr = (root.data % 2 == 0) ? root.data : 0;
// return leftSum + rightSum + curr;

// Sum of Nodes Greater Than X:
// int curr = (root.data > x) ? root.data : 0;
// return leftSum + rightSum + curr;