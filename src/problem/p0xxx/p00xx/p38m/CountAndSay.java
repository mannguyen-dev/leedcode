package problem.p0xxx.p00xx.p38m;

import problem.UtilityClass;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n -1);

        StringBuilder res = new StringBuilder();
        int count = 1;

        for (int i = 0; i < prev.length(); i++){
            if (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i+ 1)){
                count++;
            }else{
                res.append(String.valueOf(count) + prev.charAt(i));
                count = 1;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        UtilityClass.logResult(countAndSay(n));
    }
}
