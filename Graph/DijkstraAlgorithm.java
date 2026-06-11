package Graph;
import java.util.*;

public class DijkstraAlgorithm { // O((V + E) logV) / O(E log V) & O(V)
    static class Pair {
        int node;
        int distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static void dijkstra(ArrayList<ArrayList<Pair>> graph, int source) {
        int v = graph.size();
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dist = current.distance;
            if(dist > distance[node]) {
                continue;
            }

            for(Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.distance;
                if(dist + weight < distance[nextNode]) {
                    distance[nextNode] = dist + weight;
                    pq.offer(new Pair(nextNode, distance[nextNode]));
                }
            }
        }

        for(int i=0 ; i<v ; i++) {
            System.out.println(source + " -> " + i + " = " + distance[i]);
        }
    }
    
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 4));
        graph.get(0).add(new Pair(2, 1));
        graph.get(1).add(new Pair(0, 4));
        graph.get(1).add(new Pair(3, 2));
        graph.get(2).add(new Pair(0, 1));
        graph.get(2).add(new Pair(3, 5));
        graph.get(3).add(new Pair(1, 2));
        graph.get(3).add(new Pair(2, 5));

        System.out.println("Shortest Path from 0: ");
        dijkstra(graph, 0);
    }
}

// Dijkstra finds shortest paths in weighted graphs with non-negative weights.
// Edge weights must be non-negative.

// Always process the vertex having the smallest known distance.
// Use - PriorityQueue (Min Heap)

// Algorithm:
// Initialize: distance[source] = 0
// All others: ∞
// Push source into priority queue.
// While queue not empty:
// Remove front node from queue.
// Relax all neighbors.
// Update distances if shorter path found.

// Relaxation:
// Check: distance[u] + w < distance[v]
// If true: distance[v] = distance[u] + w

// Why BFS Doesn't Work?
// Consider:
// 0 --(100)-- 1
//  \
//   \(1)
//    \
//     2 --(1)-- 1
// BFS sees:
// 0 → 1
// in one edge.
// Distance:
// 1 edge
// But actual cost: 100
// Better path:
// 0 → 2 → 1
// Cost = 2
// Therefore: BFS fails for weighted graphs.

// Why O(E logV) not O((V + E) logV)?
// In a connected graph:
// E ≥ V - 1
// So E is usually much larger than V.
// Example:
// V = 1000
// E = 50000

// Frequently asked variations:
// Shortest Path to Destination
// Network Delay Time
// Minimum Cost Path
// Path Reconstruction