package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class MinimumHops {

    public static int solve(int n, int jumps[]) {
        int dp[] = new int[n];
        int pos[] = new int[n];
        int INT_MAX = 999999;
        Arrays.fill(dp, INT_MAX);
        dp[0] = 0;
        for (int i=1;i<n;i++) {
            for (int j=0; j<i; j++) {
                int delta = i-j;
                if (jumps[j] >= delta) {

                    if (dp[j] + 1 < dp[i]){
                        dp[i] = dp[j] + 1;
                        pos[i] = j;
                    }
                }
            }
        }
/*        for(int i=0;i<n;i++)
            System.out.print(dp[i] + " ");
        System.out.println();*/
        if (dp[n-1] == INT_MAX ) return -1;
        return dp[n-1];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int n =  Integer.parseInt(br.readLine());
            int nums[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            System.out.println(solve(n, nums));
        }
    }
}
