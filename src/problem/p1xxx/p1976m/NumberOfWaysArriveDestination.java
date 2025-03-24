package problem.p1xxx.p1976m;

import problem.UtilityClass;

import java.util.*;

public class NumberOfWaysArriveDestination {
    private static final int MOD = 1000000007;

    public static int countPaths(int n, int[][] roads) {

        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads){
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }

        Queue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minHeap.offer(new long[]{0, 0});
        boolean[] processed = new boolean[n];

        long[] countWays = new long[n];
        countWays[0] = 1;
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[0] = 0L;

        while(!minHeap.isEmpty()){
            long[] curr = minHeap.poll();
            long cost = curr[0];
            int currNode = (int) curr[1];

            if (processed[currNode]) continue;

            processed[currNode] = true;

            for (long[] neighbor : adj.get(currNode)){
                int nbr = (int) neighbor[0];
                long weight = neighbor[1];

                if (!processed[nbr]){
                    if (cost + weight == minCost[nbr]){
                        countWays[nbr] = (countWays[nbr] + countWays[currNode]) % MOD;
                    } else if (cost + weight < minCost[nbr]){
                        minCost[nbr] = cost + weight;
                        countWays[nbr] = countWays[currNode];
                        minHeap.offer(new long[]{cost + weight, nbr});
                    }
                }
            }
        }

        return (int) countWays[n-1];
    }

    public static void main(String[] args) {
        int n = 7;

        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        UtilityClass.logResult(countPaths(n, roads));
    }
}
