package problem.p2xxx.p25xx.p2965e;

import java.util.*;

public class Main {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int[] arrs: grid){
//            for (int n: arrs){
//                list.add(n);
//            }
//        }
//
//        Collections.sort(list);
//        System.out.println(list);
//
//        int[] res = new int[2];
//        int i = 0;
//        for (; i < list.size() - 1; i++){
//            if (Objects.equals(list.get(i), list.get(i + 1))){
//                res[0] = list.get(i);
//                System.out.println(i+ " b "+list.get(i) + " " + Arrays.toString(res));
//            }
//
//            if (!list.contains(i + 1)){
//                res[1] = i + 1;
//                System.out.println(i +" a "+ i+ 1+  " " + Arrays.toString(res));
//            }
//        }
//
//        if (!list.contains(i + 1)){
//            res[1] = i + 1;
//            System.out.println(i +" a "+ i+ 1+  " " + Arrays.toString(res));
//        }

//        return res;

//        int[] res = new int[2];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = grid.length;
//
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                if (map.containsKey(grid[i][j])){
//                    map.put(grid[i][j], map.get(grid[i][j]) + 1);
//                } else {
//                    map.put(grid[i][j], 1);
//                }
//            }
//        }
//
//        for (int i = 1; i < n * n + 1; i++){
//            if (!map.containsKey(i)){
//                res[1] = i;
//                continue;
//            }
//
//            if (map.get(i) == 2){
//                res[0] = i;
//            }
//        }
//
//        return res;

//        int[] res = new int[2];
//        Set<Integer> set = new HashSet<>();
//        int n = grid.length;
//
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                boolean ret = set.add(grid[i][j]);
//                if (!ret){
//                    res[0] = grid[i][j];
//                }
//            }
//        }
//
//        for (int i = 1; i < n * n + 1; i++){
//            if (!set.contains(i)){
//                res[1] = i;
//            }
//        }
//
//        return res;

        int[] res = new int[2];
        int n = grid.length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int cur = Math.abs(grid[i][j]);
                int col = (cur - 1)%n;
                int row = (cur - 1)/n;
                if (grid[row][col] < 0){
                    res[0] = cur;
                    continue;
                }
                grid[row][col] *= (-1);
            }
        }

        System.out.println(Arrays.deepToString(grid));

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] > 0){
                    res[1] = i*n + j + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
        //int[][] grid = {{1,3},{2,2}};

        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
}
