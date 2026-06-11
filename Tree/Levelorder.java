package Tree;

import java.util.*;

// BFS Traversal (uses Queue)
public class Levelorder { // O(n) & O(n)

    static void levelorder(Node root) {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");
            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Level Order Traversal: ");
        levelorder(root);
    }
}

// 1. Create a Queue
// 2. Insert root into Queue
// 3. While Queue is not empty:
//       Remove front node
//       Print it
//       Add its left child
//       Add its right child