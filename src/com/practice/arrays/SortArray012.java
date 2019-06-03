package com.practice.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArray012 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuffer out = new StringBuffer();
        int t = sc.nextInt();
        for ( int i = 0; i < t ; i++) {
            Map<Integer,Integer> lookup = new LinkedHashMap<>();
            lookup.put(0,0);
            lookup.put(1,0);
            lookup.put(2,0);
            long n = sc.nextLong();
            sc.nextLine();
            List<Integer> arr = Stream.of(sc.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            arr.forEach( num -> {
                lookup.put(num, lookup.get(num)+ 1);
            });
            lookup.forEach( (k,v) -> {
                for(int j=0;j<v;j++) out.append(k + " ");
            });
            out.append("\n");
        }
        System.out.println(out);
    }
}
