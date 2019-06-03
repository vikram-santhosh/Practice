package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Knapsack {

    public static int solve(int N, int W, int[] wt, int[] val){
        int dp[][] = new int[W+1][N+1];
        int res = 0;
        for (int i=0; i<=W; i++) {
            for (int j=0; j<=N; j++) {
                if (i==0 || j==0 ) dp[i][j] = 0;
                else if (wt[j] <= i) {
                    dp[i][j] = Math.max(dp[i][j-1], val[j] + dp[i - wt[j]] [j-1] );
                     res  = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

/*        for (int i=0; i<=W; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/
        return res;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int N =  Integer.parseInt( br.readLine());
            int W =  Integer.parseInt( br.readLine());
            int values[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int weights[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int wt[] = new int[N+1];
            int val[] = new int[N+1];

            for (int i=0;i<N;i++) {
                wt[i+1] = weights[i];
                val[i+1] = values[i];
            }
            System.out.println(solve(N,W,wt,val));
        }

    }
}
