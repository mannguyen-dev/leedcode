package problem.p1092h;

public class Main {
    public static String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        String lcs = findLCS(str1,str2);

        int p1 = 0, p2 = 0;
        for (char c: lcs.toCharArray()){
            while (str1.charAt(p1) != c){
                ans.append(str1.charAt(p1++));
            }
            while (str2.charAt(p2) != c){
                ans.append(str2.charAt(p2++));
            }
            ans.append(c);
            p1++;
            p2++;
        }
        ans.append(str1.substring(p1));
        ans.append(str2.substring(p2));

        return ans.toString();
    }

    public static String findLCS(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while(i>0 && j>0){
            if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                lcs.append(s1.charAt(i -1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println("Longest Common Subsequence: " + findLCS(s1, s2));

        System.out.println(shortestCommonSupersequence(s1, s2));
    }
}
