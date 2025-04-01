package problem.p0xxx.p00xx.p28e;

import java.util.Arrays;

public class Main {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        int[] lps = calculateLongestPrefixSuffix(needle);
        return patternMatcher(haystack, needle, lps);
    }

    private static int[] calculateLongestPrefixSuffix(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        Arrays.fill(lps, 0);
        int l = 0;
        int r = 1;

        while(r < n){
            if (needle.charAt(l) == needle.charAt(r)){
                lps[r] = l+1;
                l++;
                r++;
                continue;
            }

            if (l > 0){
                l = lps[l-1];
            } else {
                r++;
            }
        }
        return lps;
    }

    private static int patternMatcher(String haystack, String needle, int[] lps) {
        int hPos = 0;
        int nPos = 0;
        if (needle.length() > haystack.length()){
            return -1;
        }
        while (hPos < haystack.length() && nPos < needle.length()){
            if (haystack.charAt(hPos) == needle.charAt(nPos)){
                hPos++;
                nPos++;
            }

            if (nPos == needle.length()){
                return hPos - needle.length();
            }

            if (hPos != haystack.length() && haystack.charAt(hPos) != needle.charAt(nPos)){
                if (nPos > 0){
                    nPos = lps[nPos-1];
                } else {
                    hPos++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "issipi"));
    }
}
