package problem.p1358m;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put('a', 0);
        frequencies.put('b', 0);
        frequencies.put('c', 0);

        char[] chars = s.toCharArray();

        while (r < chars.length){
            frequencies.put(chars[r], frequencies.get(chars[r]) + 1);

            while (frequencies.get('a') > 0 && frequencies.get('b') > 0 && frequencies.get('c') > 0){
                res += chars.length - r;
                frequencies.put(chars[l], frequencies.get(chars[l]) - 1);
                l++;
            }
            r++;
        }

        return res;
    }

    public static int numberOfSubstrings2(String s) {
        int n = s.length();
        int res = 0;
        int l = 0;
        int r = 0;
        int[] freq = new int[3];

        while (r < n){
            freq[s.charAt(r) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                res += n - r;
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings2("abcabc"));
    }
}
