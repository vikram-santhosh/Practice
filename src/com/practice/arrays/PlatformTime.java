package com.practice.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


public class PlatformTime {

    public static Scanner sc = new Scanner(System.in);

    public static int solve(int arr[], int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1, j = 0;
        int trains = 1, platforms = 1;

        while(i<n && j<n) {
            if(arr[i] <= dep[j]) {
                trains ++;
                i++;
                platforms = Math.max(trains, platforms);
            } else {
                trains --;
                j++;
            }
        }
        return platforms;
    }

    public static void main (String[] args) {
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] arr = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int[] dep = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

            System.out.println(solve(arr, dep, n));
        }
    }
}