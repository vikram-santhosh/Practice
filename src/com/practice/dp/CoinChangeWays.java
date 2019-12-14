package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 02-Nov-19.
 */
public class CoinChangeWays {


    public static int solve(int val[], int target) {
        int n = val.length - 1;
        int dp[][] = new int[n+1][target+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i=1;i<=n;i++) {
            for(int j=0;j<=target; j++) {
                if (j >= val[i]) dp[i][j] = dp[i][j-val[i]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int n =  Integer.parseInt(br.readLine());
            int nums[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int target =  Integer.parseInt(br.readLine());
            int vals[] = new int[n+1];
            for(int i=0;i<n;i++) vals[i+1] = nums[i];
            System.out.println(solve(vals, target));
        }
    }
}
