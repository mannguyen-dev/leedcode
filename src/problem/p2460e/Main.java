package problem.p2460e;

import java.util.Arrays;

public class Main {
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int indexOfZero = 0;
        for (int i = 0; i < n; i++){
            if (i < n - 1 && nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }

            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[indexOfZero];
                nums[indexOfZero] = temp;
                indexOfZero++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 0, 3, 0, 4};
        int[] result = applyOperations(nums);
        System.out.println(Arrays.toString(result)); // Output: [1, 4, 3, 4, 0, 0, 0]
    }
}
