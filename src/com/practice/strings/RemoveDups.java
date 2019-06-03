package com.practice.strings;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RemoveDups {
    public static String removeDups(String str) {
        String[] words = str.split(" ");
        StringBuffer output = new StringBuffer();
        Map<Character,Boolean> lookup = new TreeMap<>();
        for(char ch: str.toCharArray()) {
            if(!lookup.containsKey(ch)) lookup.put(ch, true);

        }
        for(char ch: str.toCharArray()) {
            //if(ch == ' ') output.append(ch);
            if(lookup.get(ch)) {
                lookup.put(ch, false);
                output.append(ch);
            }
        }

        return output.toString();
    }
    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- !=0) {
            String str = br.readLine();
            System.out.println(removeDups(str));
        }

    }
}