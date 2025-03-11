package problem.p1xxx.p1046e;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int m: stones){
            pq.add(m);
        }

        while (pq.size() >= 2){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 != stone2){
                pq.add(stone1 - stone2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }
}
