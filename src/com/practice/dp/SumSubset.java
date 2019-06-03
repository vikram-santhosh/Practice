package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SumSubset {

    public static boolean solve(int arr[], int sum) {
        int n = arr.length - 1;
        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i=0;i<=n;i++) {
            for(int j=0;j<=sum; j++) {
                if( i == 0 ) dp[i][j] = false;
                if ( j == 0) dp[i][j] = true;
            }
        }

        for (int i=1; i<=n; i++) {
            for(int j=1;j<=sum; j++) {
                if (arr[i] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j-arr[i]] || dp[i-1][j];
            }
        }

/*
        for (int i=0; i<=n; i++) {
            for(int j=0;j<=sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
*/

        return dp[n][sum];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int in[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int sum = Integer.parseInt(br.readLine());
            int arr[] = new int[in.length + 1];
            for(int i=0; i<in.length;i++) arr[i+1] = in[i];

            System.out.println(solve(arr,sum));
        }
    }
}
