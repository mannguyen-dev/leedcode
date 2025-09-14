package problem.p0xxx.p05xx.p0966m;

import problem.UtilityClass;

import java.util.*;

public class VowelSpellchecker {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        UtilityClass.logResult(spellchecker(wordlist, queries));
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        //
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelsMap = new HashMap<>();
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

        for (String word : wordlist){
            String lower = word.toLowerCase();
            String masked = mask(lower);

            caseMap.computeIfAbsent(lower, k -> word);
            vowelsMap.computeIfAbsent(masked, k -> word);
        }

        List<String> res = new ArrayList<>();

        for (String query: queries){
            if (exactWords.contains(query)){
                res.add(query);
            } else

            if (caseMap.containsKey(query.toLowerCase())){
                res.add(caseMap.get(query.toLowerCase()));
            } else

                res.add(vowelsMap.getOrDefault(mask(query.toLowerCase()), ""));
        }

        return res.toArray(new String[0]);
    }

    private static String mask(String query) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> vowels = Set.of('o', 'a', 'i', 'u', 'e');
        for (Character c: query.toCharArray()){
            stringBuilder.append(vowels.contains(c) ? '*' : c);
        }
        return stringBuilder.toString();
    }
}
