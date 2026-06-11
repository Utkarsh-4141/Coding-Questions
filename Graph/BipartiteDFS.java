package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS { // O(V + E) & O(V)
    static boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, int currentColor, int[] color) {
        color[node] = currentColor;
        for(int neighbor : graph.get(node)) {
            if(color[neighbor] == -1) {
                if(!dfs(graph, neighbor, 1 - currentColor, color)) {
                    return false;
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
                if(!dfs(graph, i, 0, color))
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
