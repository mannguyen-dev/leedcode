package problem.p2xxx.p25xx.p2551h;

import problem.UtilityClass;

import java.util.*;

public class PutMarblesInBags {
    public static long putMarbles(int[] weights, int k) {
        if (k == weights.length){
            return 0;
        }

        // Step 1: Calculate the splits
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < weights.length - 1; i++){
            minQueue.add(weights[i] + weights[i+1]);
            maxQueue.add(weights[i] + weights[i+1]);
        }

        // Step 2: Calc max and min
        long max = 0;
        long min = 0;
        for (int i = 1; i < k ; i++){
            min += minQueue.poll();
            max += maxQueue.poll();
        }

        return max - min;
    }

    public static long putMarbles2(int[] weights, int k) {
        if (k == weights.length){
            return 0;
        }

        // Step 1: Calculate the splits and sort
        List<Integer> splits = new LinkedList<>();
        for (int i = 0; i < weights.length - 1; i++){
            splits.add(weights[i] + weights[i+ 1]);
        }
        splits.sort(Comparator.comparingInt(a -> a));

        // Step 2: Calc max and min
        long max = 0;
        long min = 0;
        for (int i = 0; i < k - 1; i++){
            min += splits.get(i);
            max += splits.get(splits.size() - i -1);
        }

        return max - min;
    }

    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k = 2;
        UtilityClass.logResult(putMarbles(weights, k));
    }
}
