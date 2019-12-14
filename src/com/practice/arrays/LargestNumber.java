
package com.practice.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestNumber {

    public String solve(List<String> arr) {
        Comparator<String> comparator = (String x, String y) -> {
           return (y+x).compareTo(x+y);
        };
        Collections.sort(arr, comparator);

        StringBuilder sb = new StringBuilder();
        for(String str : arr) sb.append(str);
        return sb.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        LargestNumber obj = new LargestNumber();
        while(t>0) {
            int n = sc.nextInt();
            sc.nextLine();
            List<String> input = Stream.of(sc.nextLine().split("\\s+")).collect(Collectors.toList());
            System.out.println(obj.solve(input));
            t--;
        }
    }
}

