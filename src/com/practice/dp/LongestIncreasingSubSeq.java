package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class LongestIncreasingSubSeq {
    public static int findLongestIncreasingSubSeq(int  n, int arr[]) {

        int lis[] = new int[n];
        Arrays.fill(lis,1);
        int max = -1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if ( arr[i] > arr[j] ) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            max  = Math.max(lis[i], max);
        }
        return max;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- !=0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            System.out.println(findLongestIncreasingSubSeq(n, arr));
        }

    }
}
