package com.practice.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstKTimes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            Map<Integer,Integer> lookup = new HashMap<>();
            List<Integer> input = Stream.of(sc.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            for (int i : input){

                if(lookup.containsKey(i)) lookup.put(i, lookup.get(i) + 1);
                else lookup.put(i,1);
                //System.out.println(i + " " + lookup.get(i) + " " + k);
                if(lookup.get(i) == k) {
                    System.out.println(i);
                    break;
                }
            }
            t--;
        }
    }
}
