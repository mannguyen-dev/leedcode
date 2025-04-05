package problem.p0xxx.p00xx.p125e;

import problem.UtilityClass;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleaned.length();
        for (int i = 0; i < n / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(n - i - 1)) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r){
            while (l < s.length() && !validChar(s.charAt(l)) ) l++;
            while (r > 0 && !validChar(s.charAt(r))) r--;
            if (r == 0) return true;
            if (!compareCharInsensitive(s.charAt(l), s.charAt(r))) return false;
            l++;
            r--;
        }

        return true;
    }

    public static boolean compareCharInsensitive(char a, char b){
        if (a == b) return true;
        if (a>= 'a' == a <= 'z'){
            return a == b + 32;
        }
        if (a>= 'A' == a <= 'Z'){
            return a == b - 32;
        }
        return false;
    }

    public static boolean validChar(char a){
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a <= '9');
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        UtilityClass.logResult(isPalindrome2(s));
    }
}
