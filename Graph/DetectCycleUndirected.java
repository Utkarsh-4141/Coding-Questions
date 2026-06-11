package Graph;
import java.util.*;

public class DetectCycleUndirected { // O(V + E) & O(V)
    static boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(graph, neighbor, node, visited))
                    return true;
            } else if(neighbor != parent)
                return true;
        }
        return false;
    }

    static boolean hasCycle(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        for(int i=0 ; i<graph.size() ; i++) {  // handles disconnected graphs
            if(!visited[i]) {
                if(dfs(graph, i, -1, visited))
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int v = 3;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(0);
        graph.get(2).add(1);
        
        System.out.println("Cycle Found: " + hasCycle(graph));
    }
}

// condition: visited && neighbor != parent

//     0
//    / \
//   1---2

// In an undirected graph:
// for each neighbor
//     if neighbor not visited
//          DFS(neighbor)
//     else if neighbor != parent
//          cycle found

// parent => Without parent tracking, every edge would look like a cycle.
// Parent tracking is the most important concept in this problem.

// Used in:
// Cycle Detection
// Number of Provinces
// Connected Components
// Kruskal's Algorithm (via DSU)