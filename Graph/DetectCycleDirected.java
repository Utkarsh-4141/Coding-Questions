package Graph;
import java.util.ArrayList;

public class DetectCycleDirected { // O(V + E) & O(V)
    static boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(graph, neighbor, visited, pathVisited))
                    return true;
            } else if(pathVisited[neighbor])
                return true;
        }
        pathVisited[node] = false;
        return false;
    }

    static boolean hasCycle(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        for(int i=0 ; i<v ; i++) {
            if(!visited[i]) {
                if(dfs(graph, i, visited, pathVisited))
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
        graph.get(1).add(2);
        graph.get(2).add(0);

        System.out.println("Cycle Found: " + hasCycle(graph));
    }
}

// condition: visited && pathVisited[neighbor] == true

// A cycle exists if during DFS we reach a node that is already present in the current DFS path.
// pathVisited[node] -> Tells whether node is currently in the recursion stack.

// Algorithm: For every neighbor
// Case 1
// Neighbor not visited -> dfs(neighbor)
// Case 2
// Neighbor already in recursion stack -> pathVisited[neighbor] == true
// Cycle detected.

// Suppose DFS is at:
// 0 → 1 → 2
// Then:
// visited = [T,T,T] & pathVisited = [T,T,T]
// If node 2 reaches node 0: pathVisited[0] = true
// Therefore: Cycle Found

// Consider: 
// 0 → 1 → 2
// 3 → 1
// When DFS starts from 3: Node 1 is already visited.
// But: pathVisited[1] == false
// So: No Cycle
// This is why we need both arrays.

// A directed graph can be topologically sorted only if: No cycle exists

// Used in:
// Course Schedule
// Dependency Resolution
// Topological Sort
// Build Systems