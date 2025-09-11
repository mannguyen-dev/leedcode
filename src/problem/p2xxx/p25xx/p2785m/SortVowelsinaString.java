package problem.p2xxx.p25xx.p2785m;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortVowelsinaString {
    public static void main(String[] args) {
        UtilityClass.logResult(sortVowels("lEetcOde"));
    }

    public static String sortVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder res = new StringBuilder();
        List<Character> sVowels = new ArrayList<>();
        for (char c: s.toCharArray()){
            if (vowels.contains(c)){
                sVowels.add(c);
            }
        }

        sVowels.sort(((o1, o2) -> o1 - o2));

        int j = 0;
        for (int i = 0; i < s.length(); i++){
            if (vowels.contains(s.charAt(i))){
                res.append(sVowels.get(j++));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
