package com.practice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 08-Jun-19.
 */
public class SprialOrderMatrix {

    public static void printSprial(int[][] mat, int m, int n) {
        int row_count = 0;
        int col_count = 0;
        int row_max = m - 1;
        int col_max = n - 1;
        List<Integer> arr = new ArrayList<>();
        while( row_count <= row_max && col_count <= col_max) {

            for(int i=col_count; i<=col_max; i++) arr.add(mat[row_count][i]);
            row_count ++;

            for(int i=row_count; i<=row_max; i++) arr.add(mat[i][col_max]);
            col_max --;

            //if(row_count < row_max)
            for(int i=col_max; i>=col_count ; i--) arr.add(mat[row_max][i]);
            row_max --;

            //if(col_count < col_max)
            for(int i=row_max; i>=row_count ; i--) arr.add(mat[i][col_count]);
            col_count ++;
        }

        for(int x : arr) System.out.print(x + " ");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            int mat[][] = new int[m][n];
            int arr[] = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    mat[i][j] = arr[i*n + j];
                }
            }
            printSprial(mat, m, n);
        }
    }
}
