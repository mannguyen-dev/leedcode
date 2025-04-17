package problem.p0xxx.p00xx.p14e;

import problem.UtilityClass;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        UtilityClass.logResult(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++){
                if (strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
