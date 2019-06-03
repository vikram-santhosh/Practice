package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/*
    https://practice.geeksforgeeks.org/problems/cutted-segments/0
 */
public class LineSegmentCutting {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t!=0) {
            int n = Integer.parseInt(br.readLine().trim());
            int cuts[] = Stream.of(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();
            int dp[][] = new int[cuts.length+1][n+1];
            for(int i=0;i<=cuts.length;i++){
                for(int j=0;j<=n;j++) {
                    if(i ==0 || j == 0) dp[i][j] = 0;
                    else if (j>=cuts[i-1]) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-cuts[i-1]] + 1);
                    else dp[i][j] = dp[i-1][j];
                }
            }
            System.out.println(dp[cuts.length][n]);

            t--;
        }


    }
}
