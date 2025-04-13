package problem.p0xxx.p00xx.p50m;

import problem.UtilityClass;

public class BinaryExponentiation {
    public static double myPow(double x, int n) {
        double res = 1;
        long b = Math.abs((long) n);

        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            b /= 2;
            x *= x;
        }

        return n > 0 ? res : 1/res;
    }

    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        UtilityClass.logResult(myPow(x,n));
    }
}
