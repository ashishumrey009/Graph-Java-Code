import java.util.*;
public class DfsIterative {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {4, 5}, {6, 7}};
        int V = 8; // Total number of vertices
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        System.out.println(adjList);
        boolean []visited= new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsItr(i,adjList,visited);
            }
        }

    }
    public static void dfsItr(int start,List<List<Integer>> adjList,boolean [] visited){
            Stack<Integer> stk = new Stack<>();
            visited[start]=true;
            stk.push(start);
            while(!stk.isEmpty()){
                int curr = stk.pop();
                System.out.print(curr+" ");
                for(Integer neighbor:adjList.get(curr)){
                    if(!visited[neighbor]){
                        visited[neighbor]=true;
                        stk.push(neighbor);
                    }
                }
               
            }
             System.out.println();
    }
}

// DFS for Disconnected Components:
// 0 1 2 
// 3 4 5 
// 6 7 

