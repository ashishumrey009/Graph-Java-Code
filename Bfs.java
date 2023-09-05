import java.util.*;
class Bfs{
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
                System.out.print("BFS starting from vertex " + i + ": ");
                bfs(adjList, i, visited);
                System.out.println();
            }
        }

    } 
    public static void bfs(List<List<Integer>> adhList,int v,boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        visited[v]= true;
        que.offer(v);
        while(!que.isEmpty()){
            int curr = que.poll();
            System.out.println(curr+" ");
            for(Integer neighbor: adhList.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    que.offer(neighbor);
                }
            }
        }

    }
}