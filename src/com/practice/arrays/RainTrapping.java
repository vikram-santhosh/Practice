package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 08-Jun-19.
 */
public class RainTrapping {

    public static int sovle(int arr[], int n) {
        int left[] = new int[n];
        int right[] = new int[n];
        int res = 0;
        left[0] = arr[0];
        right[n-1] = arr[n-1];

        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        for(int i=n-2; i>=0 ; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        for (int i=0; i<n ;i++) {
            int partial = Math.min(left[i], right[i]) - arr[i];
            res += partial > 0 ? partial : 0;
        }
        return res;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            System.out.println(sovle(arr, n));
        }
    }
}
