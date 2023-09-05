
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleBfs {
     public static void main(String[] args) {
         int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4},{4,1}};
        int V = 5, E = 5;
        List<List<Integer>> adj=  new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int [] edge:edges){
            int u= edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.print(isCycle(V,adj));
     }
     public static boolean isCycle(int v, List<List<Integer>> adj){
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i] && isCycleBFS(adj, v, i, visited)) {
                return true;
            }
        }

        return false;
    }
    public static boolean isCycleBFS(List<List<Integer>> adj,int v, int start, boolean[] visited){
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{start,-1});
        visited[start]= true;
        while(!queue.isEmpty()){
            int [] currPair = queue.poll();
            int curr = currPair[0];
            int parent = currPair[1];
            for(Integer neighbor:adj.get(curr)){
                if(!visited[neighbor]){
                    queue.offer(new int[]{neighbor,curr});
                    visited[neighbor]=true;
                }else if(neighbor!=parent){
                    return true;
                }
            }
        }
        return false;

    }
     
}
