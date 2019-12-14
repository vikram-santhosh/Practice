package com.practice.hashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 28-Oct-19.
 */
public class EqualFreq {
    public static Scanner sc = new Scanner(System.in);

    public static int solve(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : chars) freq.put(ch, freq.getOrDefault(ch, 0) +1 );

        Map<Integer, List<Character>> freqToChars = new HashMap<>();

        freq.forEach((character,count) -> {
            freqToChars.computeIfAbsent(count, k -> new ArrayList<>()).add(character);
        });


        if (freqToChars.size() == 1) return 1;
        if (freqToChars.size() == 2) {
            List<Map.Entry<Integer, List<Character>>> entries = freqToChars.entrySet().stream().collect(Collectors.toList());
            Map.Entry<Integer, List<Character>> first = entries.get(0);
            Map.Entry<Integer, List<Character>> second = entries.get(1);

            if (Math.abs(first.getKey() - second.getKey()) == 1 && (first.getValue().size() == 1 || second.getValue().size() == 1)) return 1;
        }
        return 0;
    }

    public static void main (String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            String str = sc.nextLine();
            System.out.println(solve(str));
        }
    }
}
