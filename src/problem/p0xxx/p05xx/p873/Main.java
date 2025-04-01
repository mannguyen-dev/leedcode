package problem.p0xxx.p05xx.p873;

import java.util.HashMap;

public class Main {
//    public static int lenLongestFibSubseq(int[] arr) {
//        ArrayList<Integer> copiedArr = new ArrayList<>(Arrays.stream(arr).boxed().toList());
//        int res = 0;
//        int prev, cur, next, lenth;
//
//        for (int i = 0; i < arr.length -1; i++){
//
//            for (int j = i +1; j <arr.length; j++){
//                prev = arr[i];
//                cur = arr[j];
//                next =prev + cur;
//                lenth = 2;
//                while (copiedArr.contains(next)){
//                    lenth++;
//                    prev = cur;
//                    cur = next;
//                    next = prev +cur;
//                    res = Math.max(res, lenth);
//                }
//            }
//        }
//
//        return res;
//    }

    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLength = 0;

        // Save pos of each elements
        for (int i = 0; i < n; i++){
            indexMap.put(arr[i], i);
        }

        // Go through the pairs of (i, j) to build the Fibonacci seq
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int x = arr[j] - arr[i]; // the number before arr[i]
                if (x < arr[i] && indexMap.containsKey(x)){
                    int k = indexMap.get(x);
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength > 2 ? maxLength : 0;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
