package com.practice.dp;

import java.util.Arrays;

/**
 * Created by Flinstone on 02-Nov-19.
 */
public class LongestPalindromicSubstring {

    public static int solve(char[] ch) {
        int n = ch.length;
        boolean dp[][] = new boolean[n][n];
        int maxLen = 1;

        for(int i=0; i<n; i++) dp[i][i] = true;

        for(int width=2;width<=n;width++) {
            for(int i=0; i<=n-width;i++) {
                int j = i + width - 1;
                if (ch[i] == ch[j]) {
                    if (width == 2) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j]) maxLen = Math.max(maxLen, width);
            }
        }

        return maxLen;
    }
    public static void main(String args[]) {
        String[] str = { "abbcaabbbaaeg", "abc", "aabc", "abba", "ccbcceaba" };
        Arrays.stream(str).forEach(i -> System.out.println(solve(i.toCharArray())));
    }
}
