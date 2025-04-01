package problem.p0xxx.p00xx.p70e;

import problem.UtilityClass;

import java.util.*;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int count = 0;

        while(!queue.isEmpty()){
            int curArr = queue.poll();
            if (curArr >= 2){
                int arr21 = curArr - 1;
                queue.add(arr21);
                int arr22 = curArr - 2;
                queue.add(arr22);

            } else if (curArr == 1){
                int arr1 = 0;
                queue.add(arr1);

            } else if (curArr == 0) {
                count++;
            }
        }

        return count;
    }

    public static int climbStairs2(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        return climbStairs2(n - 1) +climbStairs2(n-2); // recursion
    }

    public static int climbStairs3(int n) {
        // Dynamic Programing
        int one = 1;
        int two = 1;

        for (int i = 0; i < n - 1; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    public static void main(String[] args) {
        UtilityClass.logResult(climbStairs3(44));
    }
}
