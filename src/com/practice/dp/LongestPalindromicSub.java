package com.practice.dp;

import java.util.Arrays;

/**
 * Created by Flinstone on 02-Nov-19.
 */
public class LongestPalindromicSub {

    public static int solve(char[] ch) {
        int n = ch.length;
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++) dp[i][i] = 1;

        for(int width=2;width<=n;width++) {
            for(int i=0; i<=n-width ;i++) {
                int j = i + width - 1;
                if (ch[i] == ch[j] && width == 2) dp[i][j] = 2;
                else if (ch[i] == ch[j]) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
    public static void main(String args[]) {
        String[] str = { "abbcaabbbaaeg", "abc", "aabc", "abba", "ccbcceaba" };
        Arrays.stream(str).forEach(i -> System.out.println(solve(i.toCharArray())));
    }
}
