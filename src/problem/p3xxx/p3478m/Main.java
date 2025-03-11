package problem.p3xxx.p3478m;

import java.util.*;

public class Main {
    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        int n = nums1.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++){
            list.add(new int[]{nums1[i], nums2[i], i});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++){
            if (i > 0 && list.get(i-1)[0] == list.get(i)[0]){
                res[list.get(i)[2]] = res[list.get(i-1)[2]];
            } else {
                res[list.get(i)[2]] = sum;
            }

            minHeap.add(list.get(i)[1]);
            sum += list.get(i)[1];

            if (minHeap.size() > k){
                sum -= minHeap.peek();
                minHeap.poll();
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {4,2,1,5,3};
        int[] nums2 = {10,20,30,40,50};

        int k = 2;
        System.out.println(Arrays.toString(findMaxSum(nums1, nums2, k)));
    }
}
