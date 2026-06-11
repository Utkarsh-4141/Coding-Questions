package Graph;
import java.util.*;

// BFS => Queue (level by level traversal)
public class BFSTraversal { // O(V + E) & O(V)
    static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Print Each Level on a New Line
    // static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
    //     boolean[] visited = new boolean[graph.size()];
    //     Queue<Integer> queue = new LinkedList<>();
    //     visited[start] = true;
    //     queue.offer(start);
    //     int level = 1;
    //     while(!queue.isEmpty()) {
    //         int size = queue.size();
    //         System.out.print("Level " + level + ": ");
    //         for(int i=0 ; i<size ; i++) {
    //             int node = queue.poll();
    //             System.out.print(node + " ");
    //             for(int neighbor : graph.get(node)) {
    //                 if(!visited[neighbor]) {
    //                     visited[neighbor] = true;
    //                     queue.offer(neighbor);
    //                 }
    //             }
    //         }
    //         System.out.println();
    //         level++;
    //     }
    // }
    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);

        graph.get(3).add(1);

        graph.get(4).add(1);

        System.out.println("BFS Traversal: ");
        bfs(graph, 0);
    }
}

// BFS Algorithm:
// Mark source as visited.
// Insert source into queue.
// While queue is not empty:
    // Remove front node.
    // Print it.
    // Visit all unvisited neighbors.
    // Mark them visited.
    // Add them to queue.

// visited[] => So every node must be visited only once, no infinite loop.

// BFS for Disconnected Graph:
// 0 -- 1
// 2 -- 3
// for(int i = 0; i < V; i++) {
//     if(!visited[i]) {
//         bfs(graph, i);
//     }
// }
// This traverses every connected component.

// Used for:
// Shortest path in unweighted graphs
// Connected components
// Level-order traversal
// Bipartite graph checking
// Network broadcasting problems