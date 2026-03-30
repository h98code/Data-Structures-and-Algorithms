package org.Projects.DynamicProgramming.StringDP;

import java.util.Arrays;

public class LongestCommonSubSequence {

    // TC = O(2^N) where N is the length of the smaller string
    // SC = O(N) recursion depth
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length(), text2.length());
    }

    private int helper(String s1, String s2, int n, int m){
        if(n == 0 || m == 0)
            return 0;

        if(s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + helper(s1, s2, n - 1, m - 1);

        return Math.max(helper(s1, s2, n - 1, m), helper(s1, s2, n, m - 1));
    }

    //======================================================================
    // TC = O(N*M) where N and M are the lengths of the 2 strings
    // SC = O(N*M) storage matrix + O(N+M) recursion depth = O(N*M)
    public int longestCommonSubsequence_mem(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(text1, text2, n, m, dp);
    }

    private int solve(String text1, String text2, int n, int m, int[][] dp){

        if(n == 0 || m == 0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(text1.charAt(n - 1) == text2.charAt(m - 1))
            return dp[n][m] = 1 + solve(text1, text2, n - 1, m, dp);

        return dp[n][m] = Math.max(solve(text1, text2, n - 1, m, dp), solve(text1, text2, n, m - 1, dp));
    }

    //=====================================================================================
    // TC = O(N*M) where N and M are the lengths of the 2 strings
    // SC = O(N*M) storage matrix
    public int longestCommonSubsequence_itr(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    //======================================================================================
    //TC = O(N*M)
    //SC = O(min(N,M)) storage array
    public int longestCommonSubsequence_opt(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[] prev = new int[m + 1];

            for(int i=1; i<=n; i++){

                int[] dp = new int[m + 1];

                for(int j=1; j<=m; j++){
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[j] = prev[j - 1] + 1;
                    }else{
                        dp[j] = Math.max(dp[j - 1], prev[j]);
                    }
                }
                prev = dp;
            }

            return prev[m];
        }
}
