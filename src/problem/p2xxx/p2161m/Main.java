package problem.p2xxx.p2161m;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArray(nums, pivot)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        // Solution 1
//        List<Integer> lessArr = new ArrayList<>();
//        List<Integer> greaterArr = new ArrayList<>();
//        List<Integer> equalArr = new ArrayList<>();
//
//        for (int e: nums){
//            if (e > pivot){
//                greaterArr.add(e);
//            }else if (e < pivot){
//                lessArr.add(e);
//            } else {
//                equalArr.add(e);
//            }
//        }
//        int i = 0;
//        for (int e: lessArr){
//            nums[i] = e;
//            i++;
//        }
//        for (int e: equalArr){
//            nums[i] = e;
//            i++;
//        }
//        for (int e: greaterArr){
//            nums[i] = e;
//            i++;
//        }
//        return nums;
        int n = nums.length;
        int[] res = new int[n];
        int li = 0, ri = n -1;

        for (int num : nums) {
            if (num < pivot) {
                res[li] = num;
                li++;
            }
        }

        for (int i = n - 1; i >= 0; i--){
            if (nums[i] > pivot){
                res[ri] = nums[i];
                ri--;
            }
        }

        while (li <= ri){
            res[li] = pivot;
            li++;
        }
        return res;
    }
}
