package Tree;

import java.util.*;

public class LevelorderLevelwise {

    static void printLevels(Node root) {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.print("Level " + level + ": ");
            for(int i=0 ; i<size ; i++) {
                Node current = q.poll();
                System.out.print(current.data + " ");
                if(current.left != null)
                    q.offer(current.left);
                if(current.right != null)
                    q.offer(current.right);
            }
            System.out.println();
            level++;
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
        printLevels(root);
    }
}
