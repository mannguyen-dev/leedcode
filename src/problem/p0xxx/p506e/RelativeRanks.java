package problem.p0xxx.p506e;

import problem.UtilityClass;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        int[] copied = score.clone();
        Arrays.sort(copied);
        
        for (int i = 0; i<n; i++){
            int index = binarySearch(score[i], copied);

            int rank = n-index;
            switch (rank) {
                case 1 -> res[i] = "Gold Medal";

                case 2 -> res[i] = "Silver Medal";

                case 3 -> res[i] = "Bronze Medal";

                default -> res[i] = ""+ rank;
            }
        }
        
        return res;
    }

    private static int binarySearch(int num, int[] copied) {
        int n = copied.length;
        int l = 0;
        int r = n - 1;

        while (l<=r){
            int mid = l + (r-l)/2;
            if (copied[mid] == num){
                return mid;
            }
            if (copied[mid] > num){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static String[] findRelativeRanks2(int[] score) {
        int n = score.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0]-a[0]);

        for (int i = 0;i<n;i++){
            maxHeap.add(new int[]{score[i],i});
        }

        String[] res = new String[n];
        int rank = 1;

        while (!maxHeap.isEmpty()){
            int[] top = maxHeap.poll();
            switch (rank) {
                case 1 -> res[top[1]] = "Gold Medal";

                case 2 -> res[top[1]] = "Silver Medal";

                case 3 -> res[top[1]] = "Bronze Medal";

                default -> res[top[1]] = ""+ rank;
            }
            rank++;
        }


        return res;
    }

    public static String[] findRelativeRanks3(int[] score) {
        int n = score.length;

        int[][] arr = new int[n][2];

        for (int i = 0;i<n;i++){
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b)-> b[0]-a[0]);
        String[] res = new String[n];

        for (int i = 0; i<n;i++){
            int index = arr[i][1];
            switch (index) {
                case 0 -> res[arr[index][1]] = "Gold Medal";

                case 1 -> res[arr[index][1]] = "Silver Medal";

                case 2 -> res[arr[index][1]] = "Bronze Medal";

                default -> res[arr[index][1]] = ""+ (index +1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,3,8,9,4};
        UtilityClass.logResult(findRelativeRanks3(arr));
    }
}
