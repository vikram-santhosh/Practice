package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class MaxSumIncreasingSubSeq {
    public  static  void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int e=0;e<t;e++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int pos[] = new int[n];
            int max[] = new int[n];
            int gMax = arr[0];
            for (int i=0;i<n;i++) {
                max[i] = arr[i];
                pos[i] = i;
            }
            for(int i=1; i<n; i++) {
                for(int j=0;j<i;j++) {
                    if (arr[i] > arr[j] ){
                        max[i] = Math.max((max[j] + arr[i]), max[i]);
                    }
                    gMax = Math.max(max[i],gMax);
                }
            }
            sb.append(gMax + "\n");
        }
        System.out.println(sb);
    }
}
