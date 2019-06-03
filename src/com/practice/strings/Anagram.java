package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    public static String isAnagram(String x, String y) {
        int lookup[] = new int[256];
        for(char ch: x.toCharArray()) {
            lookup[ch]++ ;
        }
        for(char ch: y.toCharArray()) {
            if(lookup[ch] == 0) return "NO";
            else lookup[ch] --;
        }
        return "YES";
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String input[] = br.readLine().split("\\s+");
            System.out.println( isAnagram(input[0], input[1])) ;
        }
    }
}
