package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static String reverse(String str) {
        StringBuffer sb = new StringBuffer();
        String words[] =  str.split("\\.");
        for(int i=words.length-1; i>0; i--)
            sb.append(words[i] + ".");
        sb.append(words[0]);
        return sb.toString();
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String str = br.readLine();
            System.out.println(reverse(str));
        }
    }
}
