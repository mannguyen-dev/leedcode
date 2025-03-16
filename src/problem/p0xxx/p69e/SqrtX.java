package problem.p0xxx.p69e;

import problem.UtilityClass;

public class SqrtX {
    public static int mySqrt(int x) {
        if (x == 1) return 1;

        int l = 1;
        int r = x/2;
        int res = r;

        while (l <= r){
            int mid = l + (r-l)/2;
            long square = (long) mid * mid;
            if (square > x){
                res = mid - 1;
                r = mid - 1;
            } else if (square == x) {
                res = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        UtilityClass.logResult(mySqrt(2147395599));
    }
}
