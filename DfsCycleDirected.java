import java.util.*;

public class DfsCycleDirected {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int u= edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        boolean [] visited = new boolean[V];
        boolean [] recStack = new boolean[V];
        System.out.println(hasCycle(adjList,visited,recStack,V));

    }
    public static boolean hasCycle(List<List<Integer>> adjList,boolean[] visited,boolean[] recStack,int v){
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(checkCycle(adjList,visited,recStack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkCycle(List<List<Integer>> adjList,boolean[] visited,boolean[] recStack,int v){
            visited[v]=true;
            recStack[v]=true;
            for(Integer neighbor:adjList.get(v)){
                if(!visited[neighbor]){
                    if(checkCycle(adjList, visited, recStack, neighbor)){
                        return true;
                    }
                }else if(recStack[neighbor]){
                    return true;
                }
            }
            recStack[v]=false;
            return false;
    }
}
