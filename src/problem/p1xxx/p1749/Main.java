package problem.p1xxx.p1749;

public class Main {
    public static int maxAbsoluteSum(int[] nums) {
        int current = 0;
        int prefix = 0;
        int min = 0;
        int max = 0;
        int res = 0;

        for (; current < nums.length; current++){
            prefix += nums[current];

            res = Math.max(res, Math.max(Math.abs(prefix - min), Math.abs(prefix - max)));
            min = Math.min(min, prefix);
            max = Math.max(max, prefix);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
    }
}
