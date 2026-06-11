package Graph;
import java.util.*;

public class BipartiteBFS { // O(V + E) & O(V)
    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int source, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        color[source] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph.get(node)) {
                if(color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if(color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        int[] color = new int[v];
        Arrays.fill(color, -1);
        for(int i=0 ; i<v ; i++) {
            if(color[i] == -1) {
                if(!bfs(graph, i, color))
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(0);
        graph.get(0).add(3);

        System.out.println("Bipartite: " + isBipartite(graph));
    }
}

// color[neighbor] = 1 - color[node];

// BFS Approach:
// Start BFS.
// Assign source color 0.
// For every neighbor:
// If uncolored → assign opposite color.
// If same color as current node → Not Bipartite.

// Are all trees bipartite?
// Yes, A tree contains no cycles, therefore no odd cycles.

// Is every even cycle bipartite?
// Yes, Color alternates perfectly.

// Bipartite Graph = can be colored using 2 colors.

// Even-length cycle -> Bipartite
// Odd-length cycle -> No Bipartite

// A graph is Bipartite if its vertices can be divided into two groups such that:
// No two adjacent vertices belong to the same group.
// Instead of groups, think of:
// Color 0
// Color 1
// Every edge must connect different colors.

// Example (Bipartite)
// 0 ----- 1
// |       |
// |       |
// 3 ----- 2

// Coloring:
// 0 -> Red
// 2 -> Red
// 1 -> Blue
// 3 -> Blue
// Every edge connects Red ↔ Blue.