package problem.p2xxx.p25xx.p2560m;

public class HouseRobberIV {
    public static int minCapability(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num:nums){
            if (max < num) max = num;
            if (min > num) min = num;
        }

        int l = min;
        int r = max;
        int res = max;

        while (l <=  r){
            int mid = l + (r-l)/2;

            if (checkAcceptable(nums, mid, k)){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }

        return res;
    }

    private static boolean checkAcceptable(int[] nums, int mid, int k) {
        int count = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[i] <= mid){
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >=k;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(nums, k));
    }
}
