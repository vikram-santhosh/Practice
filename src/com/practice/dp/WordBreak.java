package com.practice.dp;

/**
 * Created by Flinstone on 09-Nov-19.
 */
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;

public class WordBreak {

    public static Scanner sc = new Scanner(System.in);

    public static boolean isPresentDict(String word, int start, int end, Set<String> dict) {
        String str = word.substring(start, end+1);
        return dict.contains(str);
    }
    public static boolean solve(Set<String> dict, String word) {
        int n = word.length();
        boolean dp[][] = new boolean[n][n];

        for(int width=1; width<=n; width++) {
            for(int i=0;i<=n-width;i++) {
                int j = i + width - 1;
                if (isPresentDict(word,i,j,dict)) dp[i][j] = true;
                else {
                    for(int k=i;k<=j;k++)
                        if (dp[i][k] && dp[k+1][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main (String[] args) {
        String[] arr = {"i", "am", "like", "apple"};
        Set<String> dict = new HashSet<>(Arrays.asList(arr));
        int t = sc.nextInt();
        sc.nextLine();
        while(t -- != 0) {
            String input = sc.nextLine();
            System.out.println(solve(dict, input));
        }

    }
}
