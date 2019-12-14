package com.practice.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 02-Nov-19.
 */
public class SumSubset {

    public static Scanner sc = new Scanner(System.in);

    public static boolean solve(int[] val, int sum) {
        if (sum % 2 == 1) return false;

        int target = sum / 2;

        int n = val.length;
        boolean dp[][] = new boolean[n+1][target+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=target;j++) {
                if (i == 0 && j != 0 ) dp[i][j] = false;
                else if (j == 0 ) dp[i][j] = true;
                else if (j >= val[i-1] ) dp[i][j] = dp[i-1][j - val[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }

/*
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=target;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
*/

        if (!dp[n][target]) return false;

        boolean used[] = new boolean[n];
        for(int i = n, j = target; i > 0 && j > 0; i--) {
            if(j >= val[i-1] && dp[i-1][j-val[i-1]]) {
                used[i - 1] = true;
                j -= val[i - 1];
                System.out.println(val[i-1]);
            }
        }
        int comp = 0;
        for(int i=0;i<n;i++) {
            if ( !used[i] ) comp += val[i];
        }

        return comp == target;
    }

    public static void main (String[] args) {
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] arr = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            Arrays.sort(arr);
            int sum = Arrays.stream(arr).sum();
            if (solve(arr, sum)) System.out.println("YES");
            else System.out.println("NO");
            System.out.println(solve(arr, sum));
        }

/*        int arr[] = {1,3,5,11,1,1,2};
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        System.out.println(solve(arr, sum));*/
    }
}
