package Graph;

import java.util.*;

// DFS => Stack (recursion)
public class DFSTraversal { // O(V + E) & O(V)
    // static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
    //     visited[node] = true;
    //     System.out.print(node + " ");
    //     for(int neighbor : graph.get(node)) {
    //         if(!visited[neighbor]) {
    //             dfs(graph, neighbor, visited);
    //         }
    //     }
    // }

    // DFS Using Stack (Iterative)
    static void dfs(ArrayList<ArrayList<Integer>> graph, int source) {
        int v = graph.size();
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        visited[source] = true;
        st.push(source);
        while(!st.isEmpty()) {
            int node = st.pop();
            System.out.print(node + " ");
            for(int neighbor : graph.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    st.push(neighbor);
                }
            }
        }
    }
    // 0 2 1 4 3

    // How to make iterative DFS match recursive DFS?
    // Push neighbors in reverse order:
    // for(int i=graph.get(node).size()-1 ; i>=0 ; i--) {
    //     int neighbor = graph.get(node).get(i);
    //     if(!visited[neighbor]) {
    //         visited[neighbor] = true;
    //         st.push(neighbor);
    //     }
    // }
    // 0 1 3 4 2 (both are valid)

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //boolean[] visited = new boolean[v];
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

        System.out.println("DFS Traversal: ");
        // dfs(graph, 0, visited);
        dfs(graph, 0);
    }
}

// DFS Algorithm:
// Visit current node.
// Mark it visited.
// Visit every unvisited neighbor recursively.

// Foundation for:
// Cycle Detection
// Connected Components
// Number of Islands
// Topological Sort
// Path Finding