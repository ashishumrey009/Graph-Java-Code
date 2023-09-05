import java.util.ArrayList;
import java.util.List;

public class DfsCycleUndirected {
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
        boolean []visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i] && dfs(i,adj,visited,-1)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(int v,List<List<Integer>> adj,boolean[] visited,int parent){
        visited[v]=true;
        for( Integer neighbor: adj.get(v)){
            if(!visited[neighbor]){
                if(dfs(neighbor, adj, visited, v)){
                    return true;
                }
            }else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }
}
