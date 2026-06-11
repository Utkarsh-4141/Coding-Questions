package Graph;
import java.util.*;

// Kahn's Algorithm
public class TopologicalSortByBFS { // O(V + E) & O(V)
    static void topoSort(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();
        int[] indegree = new int[v];

        for(int i=0 ; i<v ; i++) {
            for(int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<v ; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            answer.add(node);
            for(int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        if(count != v)
            System.out.println("Cycle Exists");

        System.out.println(answer);
    }
    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(0);
        graph.get(5).add(2);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        System.out.println("Topological Sort: ");
        topoSort(graph);
    }
}

// Indegree = Number of incoming edges.

// Initial indegree:
// 0 = 2
// 1 = 2
// 2 = 1
// 3 = 1
// 4 = 0
// 5 = 0

// Kahn's Algorithm:
// Compute indegree of every vertex.
// Put all vertices with indegree 0 into queue.
// Remove node from queue.
// Add it to answer.
// Reduce indegree of neighbors.
// If neighbor indegree becomes 0:
// Add to queue.

// Cycle Detection in Directed Graph
// DFS → visited[] + pathVisited[]
// BFS → Kahn's Algorithm (processedNodes != V)

// Topological sort -> Only for Directed Acyclic Graphs(DAG)