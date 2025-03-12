package problem.p1xxx.p1464e;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1)* (nums[nums.length - 2] - 1);
    }

    public static int maxProduct2(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for (int num : nums){
            maxHeap.add(num);
        }

        int num1 = maxHeap.poll();
        int num2 = maxHeap.poll();

        return (num1 - 1)* (num2 - 1);
    }

    public static int maxProduct3(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int number: nums){
            if (number > max1){
                max2 = max1;
                max1 = number;
            } else if (number > max2){
                max2 = number;
            }
        }

        return (max1 -1)*(max2-1);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct3(nums));
    }
}
