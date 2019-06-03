package com.practice.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number.
 */
public class SubArraySum {
    public static Scanner sc = new Scanner(System.in);
    public static void solve() {
        int n = sc.nextInt(), sum = sc.nextInt();
        Map<Integer, Integer> lookup = new HashMap<>();
        int curr_sum = 0;
        sc.nextLine();
        List<Integer> arr = Stream.of(sc.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        //for ( int i = 0;i<n;i++) arr.add(sc.nextInt());
        for (int i = 0;i<n;i++) {
            curr_sum += arr.get(i);
            if (curr_sum == sum ) {
                System.out.println(1 +" "+ (i+1));
                return;
            }
            if (lookup.containsKey(( curr_sum - sum))){
                System.out.println( (lookup.get(curr_sum - sum) +1) +" "+ (i+1));
                return;
            }
            lookup.put(curr_sum, i+1);
        }
        System.out.println(-1);


    }
    public static void main(String args[]) {
        int t =  sc.nextInt();
        for (int i=0;i<t;i++) {
            solve();
        }
    }
}
