import java.util.*;
//here I will use distance array and not use visited array
public class MinimumDistance {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        int V = 4;
        int source = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int [] parent = new int[V];
        int [] distance = new int[V];
        Arrays.fill(parent,-1);
        Arrays.fill(distance,Integer.MAX_VALUE);
        bfs(adjList,parent,distance,source);
        int target = distance.length-1;
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));
        List<Integer> path = new ArrayList<>();
    }
    public static void bfs(List<List<Integer>> adList,int[] parent,int[] distance,int start){
        Queue<Integer>que = new LinkedList<>();
        que.add(start);
        distance[start]=0;
        while(!que.isEmpty()){
            int curr = que.poll();
            for(Integer neighbor:adList.get(curr)){
                if(distance[neighbor]==Integer.MAX_VALUE){
                    distance[neighbor]= distance[curr]+1;
                    parent[neighbor]=curr;
                    que.add(neighbor);
                }
            }
        }
    }
}
