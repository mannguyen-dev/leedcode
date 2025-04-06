package problem.p0xxx.p02xx.p215m;

import problem.UtilityClass;

import java.util.PriorityQueue;

public class KthLargestElementArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num: nums) maxHeap.add(num);

        for (int i = 0; i < k - 1; i++) maxHeap.poll();
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        UtilityClass.logResult(findKthLargest(nums, k));
    }
}
