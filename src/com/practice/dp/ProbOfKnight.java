package com.practice.dp;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 17-Nov-19.
 */
public class ProbOfKnight {

    public static int moves[][] = {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};
    public static int dp[][][];
    public static int solve(int n, int x, int y, int k) {

        if (x >= n || y >= n || y < 0 || x < 0 ) return 0;
        if (dp[x][y][k] != 0) return dp[x][y][k];

        for (int i=0;i<8;i++) {
            dp[x][y][k] += solve(n, x + moves[i][0], y + moves[i][1], k-1);
        }
        //System.out.println("dp["+ x + "]["+ y + "][" + k+ "]  => " + dp[x][y][k]);
        return dp[x][y][k];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- != 0) {
            int[] arr = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int n = arr[0];
            int x = arr[1];
            int y = arr[2];
            int k = arr[3];
            dp = new int[n][n][k+1];

            for (int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    dp[i][j][0] = 1;

            int num = solve(n, x, y, k);
            double prob = (double) num/(Math.pow(8,arr[3]));
            System.out.println(prob);
        }
    }
}
