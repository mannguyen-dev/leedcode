package problem.p2xxx.p25xx.p2685m;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberCompleteComponents {

    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int completeComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                // count nodes and edges for each component
                AtomicInteger edgesNo = new AtomicInteger(0);
                AtomicInteger nodes = new AtomicInteger(0);
                dfs(i, nodes, edgesNo, adj, visited);

                if (edgesNo.get() == (nodes.get()* (nodes.get()-1))) completeComponents++;
            }
        }

        return completeComponents;
    }

    private static void dfs(int curr, AtomicInteger nodes, AtomicInteger edgesNo, List<List<Integer>> adj, boolean[] visited) {
        nodes.incrementAndGet();
        visited[curr] = true;
        for (int nbr : adj.get(curr)){
            edgesNo.incrementAndGet();
            if (!visited[nbr]){
                dfs(nbr, nodes, edgesNo, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        UtilityClass.logResult(countCompleteComponents(n, edges));
    }
}
