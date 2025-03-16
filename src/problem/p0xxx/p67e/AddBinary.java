package problem.p0xxx.p67e;

import problem.UtilityClass;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int carry = 0;
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        StringBuilder res = new StringBuilder();

        while (ia >= 0 || ib >= 0){
            int digitA = 0;
            int digitB = 0;

            if (ia >= 0) digitA = a.charAt(ia) - '0';
            if (ib >= 0) digitB = b.charAt(ib) - '0';

            int total = digitA + digitB + carry;
            int digit = total % 2;
            carry = total / 2;

            res.insert(0, digit);

            ia--;
            ib--;
        }

        if (carry > 0){
            res.insert(0, carry);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        UtilityClass.logResult(addBinary("11", "101"));
    }
}
