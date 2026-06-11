package Graph;
import java.util.*;

public class TopologicalSortByDFS { // O(V + E) & O(V)
    static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    static void topoSort(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<v ; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(2);
        graph.get(5).add(0);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        System.out.println("Topological Sort: ");
        topoSort(graph);
    }
}

//Graph:
// 5 → 2 → 3 → 1
// ↓
// 0

// 4 → 0
// ↓
// 1

// Valid Answers:
// 5 4 2 3 1 0
// 4 5 2 3 1 0
// 5 2 4 3 1 0

// Check constraints:
// 5 before 2 ✓
// 5 before 0 ✓
// 4 before 0 ✓
// 4 before 1 ✓
// 2 before 3 ✓
// 3 before 1 ✓
// Valid Topological Ordering.

// Method 1: DFS + Stack
// Visit all descendants first.
// Push current node into stack after processing all neighbors.
// When DFS finishes:
// Stack Pop Order = Topological Order

// Topological sort -> Only for Directed Acyclic Graphs(DAG)
// A topological order is an ordering such that:
// For every edge U → V
// U appears before V