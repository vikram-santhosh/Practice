package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CoinChanging {
    public static int solve(int n, int coin[], int sum) {

        int dp[][] = new int[n+1][sum+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++) {
                if ( j == 0) dp[i][j] = 1;
                else if ( coin[i] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[n][sum];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int coin[] = new int[n+1];
            coin[0] = 0;
            for(int i=0;i<n;i++) {
                coin[i+1] = arr[i];
            }
            int sum = Integer.parseInt(br.readLine());
            System.out.println(solve(n, coin, sum));
        }
    }
}
