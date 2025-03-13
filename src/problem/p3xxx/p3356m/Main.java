package problem.p3xxx.p3356m;

import java.util.Arrays;

public class Main {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int pos = 0;
        int accumulate = 0;
        int n = nums.length;
        int[] diff = new int[n+1];
        Arrays.fill(diff, 0);

        for (int i = 0; i < n; i++ ){
            while (accumulate + diff[i] < nums[i]){
                if (pos == queries.length){
                    return -1;
                }

                int left = queries[pos][0];
                int right = queries[pos][1];
                int value = queries[pos][2];
                pos++;

                if (i > right) continue;

                diff[Math.max(i, left)] += value;
                diff[right+1] -= value;
            }
            accumulate += diff[i];
        }

        return pos;
    }

    public static void main(String[] args) {
        int[][] queries = {{0,1,4},{0,1,1},{0,1,4},{0,1,1},{1,1,5},{0,1,2},{1,1,4},{0,1,1},{1,1,3},{0,0,2},{1,1,3},{1,1,2},{0,1,5},{1,1,2},{1,1,5}};
        int[] nums = {0, 8};

        System.out.println(minZeroArray(nums, queries));

    }
}
