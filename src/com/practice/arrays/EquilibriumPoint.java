package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EquilibriumPoint {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer out = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++) {
            int res = -1;

            int n = Integer.parseInt(br.readLine());
            int left_sum = 0;
            List<Integer> arr = Stream.of(br.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            int currSumOfSq = arr.stream().map(j -> j * j).mapToInt(Integer::valueOf).sum();


            int right_sum = arr.stream().reduce(0, (x,y) -> x+y );



            for (int j=0;j<n;j++) {
                right_sum = right_sum - arr.get(j);
                if ( left_sum == right_sum) {
                    res = j + 1;
                }
                left_sum += arr.get(j);
            }
            out.append(res + "\n");
        }
        System.out.println(out);
    }
}
