package com.practice.dp;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Flinstone on 02-Nov-19.
 */
public class MinimumOperations {

    public static int solve(int N) {
        int dp[] = new int[N+1];

        for(int i=1;i<=N;i++) {
            dp[i] = ((i % 2 == 0) ? dp[i/2] : dp[i-1]) + 1;
        }

        return dp[N];
    }
    public static void main(String args[]) {
        int[] inputs = { 5,8,7,9 };
        Arrays.stream(inputs).forEach(i -> System.out.println(solve(i)));
    }
}
