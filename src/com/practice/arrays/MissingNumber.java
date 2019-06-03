package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissingNumber {

    public static Scanner sc = new Scanner(System.in);
    public static int solve() {
        int m = sc.nextInt();
        int arr[] = new int[m];
        sc.nextLine();
        List<Integer> list =  Stream.of(sc.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        int expected =  m * (m+1) / 2;
        return expected - sum;
    }
    public static void main(String args[]) {
        int t = sc.nextInt();
        for (int i=0;i<t;i++) {
            System.out.println(solve());
        }
    }
}
