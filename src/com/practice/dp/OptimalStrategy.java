package com.practice.dp;

/**
 * Created by Flinstone on 01-Nov-19.
 */
public class OptimalStrategy {

    public static int optimalStrategyOfGame(int arr[], int n) {
        int dp[][] = new int[n][n];

        for(int gap=0;gap<n;gap++) {
            for(int i=0,j=gap;i<n &&j<n;i++, j++) {/*
                if (i == j) dp[i][j] = arr[i];
                else if (j == i+1) dp[i][j] = Math.max(arr[i], arr[j]);
                else {

                }*/
                int x = (i+1 < j-1) ? dp[i+1][j-1] : 0;
                int y = (i+2 < j) ? dp[i+2][j] : 0;
                int z = (i < j-2) ? dp[i][j-2] : 0;

                dp[i][j] = Math.max(arr[i]+ Math.min(x,y) , arr[j] + Math.min(x,z));
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args)
    {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println("" + optimalStrategyOfGame(arr1, n));

        int arr2[] = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println("" + optimalStrategyOfGame(arr2, n));

        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length;
        System.out.println("" + optimalStrategyOfGame(arr3, n));
    }
}
