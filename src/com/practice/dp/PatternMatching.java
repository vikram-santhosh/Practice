package com.practice.dp;

import java.util.Scanner;

/**
 * Created by Flinstone on 09-Nov-19.
 * https://www.geeksforgeeks.org/wildcard-pattern-matching/
 */
public class PatternMatching {
    public static Scanner sc = new Scanner(System.in);

    public static boolean solve(char[] str, char[] pattern) {
        int m = pattern.length - 1;
        int n = str.length - 1;

        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if (str[i] == pattern[j] || pattern[j] == '?') dp[i][j] =  dp[i-1][j-1];
                else if(pattern[j] == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]) {
        String pattern = "ba*a?";
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            String str = sc.nextLine();
            System.out.println(solve(("0"+str).toCharArray(), ("0"+pattern).toCharArray()));
        }
    }
}
