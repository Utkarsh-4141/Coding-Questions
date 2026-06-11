package Graph;
import java.util.*;

public class ConnectedComponents { // O(V + E) & O(V)
    static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    static int count(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        boolean[] visited = new boolean[v];
        int count = 0;
        for(int i=0 ; i<v ; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visitedB) {
        Queue<Integer> queue = new LinkedList<>();
        visitedB[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph.get(node)) {
                if(!visitedB[neighbor]) {
                    visitedB[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    static int countBFS(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        boolean[] visitedB = new boolean[v];
        int countB = 0;
        for(int i=0 ; i<v ; i++) {
            if(!visitedB[i]) {
                bfs(graph, i, visitedB);
                countB++;
            }
        }
        return countB;
    }
    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(2).add(3);
        graph.get(3).add(2);

        System.out.println("DFS Connected Components: " + count(graph));
        System.out.println("BFS Connected Components: " + countBFS(graph));
    }
}

// Algorithm:
// Create visited array.
// Initialize count = 0.
// Traverse all vertices.
// If a vertex is unvisited:
// Run DFS/BFS.
// Increment count.
// Return count.

// ✅ Connected Component = group of reachable vertices.
// ✅ One DFS/BFS call completely visits one component.
// ✅ Number of DFS/BFS calls = Number of Components.

// Frequently appears as:
// Number of Provinces
// Friend Circles
// Connected Networks
// Count Islands (Matrix Version)