package com.practice.backtracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 16-Nov-19.
 * https://practice.geeksforgeeks.org/problems/probability-of-knight/0
 */
public class ProbOfKnight {

    public static int solve(int n, int i, int j, int k) {
        if ( i >= n || j >= n || i < 0 || j < 0) return 0;

        if ( k == 0) return 1;
        return solve(n, i-1, j+2, k-1) +
                solve(n, i+1, j+2, k-1) +

                solve(n, i-2, j+1, k-1) +
                solve(n, i+2, j+1, k-1) +

                solve(n, i-1, j-2, k-1) +
                solve(n, i+1, j-2, k-1) +

                solve(n, i-2, j-1, k-1) +
                solve(n, i+2, j-1, k-1);

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //int t = 1;
        while(t-- != 0) {
            sc.nextLine();
            int[] arr = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int n = solve(arr[0], arr[1], arr[2], arr[3]);
            //int n = solve(8, 0, 0, 3);
            //double m = Math.pow(3, 8);
            double prob = (double) n/(Math.pow(8,arr[3]));
            //System.out.println(n);


            System.out.println(prob);
            //System.out.println(solve(8, 0, 0, 3));
        }
    }
}
