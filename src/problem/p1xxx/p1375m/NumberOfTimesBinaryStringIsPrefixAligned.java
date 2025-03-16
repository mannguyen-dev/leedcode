package problem.p1xxx.p1375m;

import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class NumberOfTimesBinaryStringIsPrefixAligned {
    public static int numTimesAllBlue(int[] flips) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int maxElement = 0;

        for (int n: flips){
            maxElement = Math.max(maxElement, n);
            set.add(n);
            if (maxElement == set.size()){
                res++;
            }
        }
        return res;
    }

    public static int numTimesAllBlue2(int[] flips) {
        int res = 0;
        int maxElement = 0;

        for (int i = 0; i < flips.length; i++){
            maxElement = Math.max(maxElement, flips[i]);

            if (maxElement == i + 1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] flips = {3,2,4,1,5};
        UtilityClass.logResult(numTimesAllBlue2(flips));
    }
}
