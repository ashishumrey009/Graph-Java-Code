import java.util.*;

public class DFSDirectedDisconnectedComponents {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {4, 5}};
        int V = 6;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.print("DFS starting from vertex " + i + ": ");
                dfs(adjList, i, visited);
                System.out.println(); // Add a line break after each DFS traversal
            }
        }
    }

    public static void dfs(List<List<Integer>> adjList, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }
}
