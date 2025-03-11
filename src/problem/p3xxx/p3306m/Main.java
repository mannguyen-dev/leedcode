package problem.p3xxx.p3306m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k+1);
    }

    private static long atLeastK(String word, int k){
        int l = 0;
        int r = 0;
        List<Character> vowelList = List.of('a','u','i','o','e');

        Map<Character, Integer> vowel = new HashMap<>();
        char[] chars = word.toCharArray();
        int nonVowel = 0;
        long res = 0;

        while (r < chars.length){
            if (vowelList.contains(chars[r])){
                vowel.put(chars[r], vowel.get(chars[r]) == null? 1: vowel.get(chars[r]) + 1);
            } else {
                nonVowel += 1;
            }

            while (vowel.size() == 5 && nonVowel >=k){
                res += chars.length - r;
                if (vowelList.contains(chars[l])){
                    vowel.put(chars[l], vowel.get(chars[l]) - 1);
                } else {
                    nonVowel -= 1;
                }
                if (vowelList.contains(chars[l]) && vowel.get(chars[l]) == 0){
                    vowel.remove(chars[l]);
                }
                l++;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
