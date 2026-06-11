package Graph;
import java.util.*;

// BFS
public class ShortestPathUnweighted { // O(V + E) & O(V)
    static void shortestPath(ArrayList<ArrayList<Integer>> graph, int source) {
        int v = graph.size();
        int[] distance = new int[v];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        distance[source] = 0;
        queue.offer(source);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph.get(node)) {
                if(distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        for(int i=0 ; i<v ; i++) {
            System.out.println(i + " -> " + distance[i]);
        }
    }
    
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

        graph.get(2).add(0);
        graph.get(2).add(3);

        graph.get(3).add(1);
        graph.get(3).add(2);
        graph.get(3).add(4);

        graph.get(4).add(3);

        System.out.println("Shortest Paths: ");
        shortestPath(graph, 0);
    }
}

// distance[neighbor] = distance[node] + 1;

// Algorithm:
// Create distance array.
// Initialize all distances as -1.
// Distance of source = 0.
// Perform BFS.
// For every unvisited neighbor:
// distance[neighbor] = distance[node] + 1;
// Push neighbor into queue.

// DFS does not guarantee shortest path.
// BFS guarantees shortest path in unweighted graphs or graphs where every edge has equal weight.
// Distance from source = Level Number

// Q1. What if graph is weighted?
// BFS fails.
// Use:
// Dijkstra's Algorithm (positive weights)
// Bellman–Ford Algorithm (negative weights)

// if graph is disconnected?
// 0 --- 1
// 2 --- 3
// 0 -> 0
// 1 -> 1
// 2 -> -1
// 3 -> -1

// Finding Actual Path: 0 → 1 → 3 → 4
// During BFS -> parent[neighbor] = node;
// List<Integer> path = new ArrayList<>();
// int current = destination;
// while(current != -1) {
//     path.add(current);
//     current = parent[current];
// }
// Collections.reverse(path);