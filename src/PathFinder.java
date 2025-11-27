import java.util.*;

public class PathFinder {

    public static void findPath(Graph graph, int start, int end) {

        int n = graph.nodes;
        List<List<Edge>> adj = graph.adj;

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        boolean found = false;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == end) {
                found = true;
                break;
            }

            for (Edge edge : adj.get(node)) {
                int next = edge.destination;
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    q.add(next);
                }
            }
        }

        // If no path exists
        if (!found) {
            System.out.println("No path exists from " + start + " to " + end);
            return;
        }

        // Reconstruct BFS path
        List<Integer> path = new ArrayList<>();
        int curr = end;

        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);

        // Calculate TOTAL WEIGHT on the BFS path
        double totalWeight = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);

            // find the edge that matches BFS connection
            for (Edge edge : adj.get(from)) {
                if (edge.destination == to) {
                    totalWeight += edge.weight;
                    break;
                }
            }
        }

        // Print results
        System.out.println("Path: " + path);
        System.out.println("Path Total Weight: " + totalWeight);
    }
}


