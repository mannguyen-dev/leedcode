package problem.p3xxx.p3227m;

import java.util.Set;

public class VowelsGame {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels = Set.of('a', 'u', 'i', 'e', 'o');

        for (Character c : s.toCharArray()){
            if (vowels.contains(c)) return true;
        }
        return false;
    }
}
