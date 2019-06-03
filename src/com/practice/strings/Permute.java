package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permute {

    public String swap(String str, int i , int left) {
        char[] chars = str.toCharArray();
        char temp = chars[left];
        chars[left] = chars[i];
        chars[i] = temp;
        return String.valueOf(chars);
    }
    public void permute(String str, int left, int right) {
        if (left == right) System.out.print(str + " ");
        else {
            for(int i=left; i<=right; i++) {
                str = swap(str, i, left);
                permute(str, left+1, right);
                str = swap(str, i, left);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        Permute obj = new Permute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String str = br.readLine();
            obj.permute(str, 0, str.length()-1);
            System.out.println();
        }
    }
}
