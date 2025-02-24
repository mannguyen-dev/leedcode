package problem.p2467;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // Step 1: Make Adj List
        //int n = amount.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges){
            pushBack(edge[0], edge[1], adj);
            pushBack(edge[1], edge[0], adj);
        }

        // step 2: Find the Bob to root path
        List<Integer> currPath = new ArrayList<>(), bobPath = new ArrayList<>();
        findBobPath(adj, bob, -1, currPath, bobPath);

        // step 3: Update amount of half of the path nodes to 0
        int size = bobPath.size();
        int i;
        for (i=0; i < size/2; i++){
            amount[bobPath.get(i)] = 0;
        }

        if ((size & 1) == 1){
            amount[bobPath.get(i)] = 0;
        } else {
            amount[bobPath.get(i)] /= 2;
        }
        
        // step 4: apply DFS to find the max sum
        return findMaxIncomeForAlice(adj, 0, -1, amount);
    }

    private static int findMaxIncomeForAlice(HashMap<Integer, List<Integer>> adj, int alice, int parent, int[] amount) {
        int maxIncome = Integer.MIN_VALUE;
        for (int nbr : adj.get(alice)){
            if (nbr != parent){
                int income = findMaxIncomeForAlice(adj, nbr, alice, amount);
                if (income + amount[alice] > maxIncome){
                    maxIncome = income + amount[alice];
                }
            }
        }
        return maxIncome == Integer.MIN_VALUE ? amount[alice] : maxIncome;
    }

    private static boolean findBobPath(HashMap<Integer, List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
        if (bob == 0){
            bobPath.addAll(currPath);
            return true;
        }

        // Traverse all nbrs
        currPath.add(bob);
        for (int nbr : adj.get(bob)){
            if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)){
                return true;
            }
        }

        currPath.removeLast();
        return false;
    }

    private static void pushBack(int head, int tail, HashMap<Integer, List<Integer>> adj) {
        List<Integer> temp = adj.get(head);
        if (temp == null){
            temp = new ArrayList<>();
        }
        temp.add(tail);

        adj.put(head, temp);
    }

    public static void main(String[] args) {
        int[][] arrs = {{0,1},{1,2},{1,3},{3,4}};
        int[] amount = {-2,4,2,-4,6};
        System.out.println(mostProfitablePath(arrs, 3, amount));
    }
}
