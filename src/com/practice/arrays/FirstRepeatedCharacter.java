package com.practice.arrays;

import java.util.Scanner;

public class FirstRepeatedCharacter {

    public static int getPosition(char[] word) {
        int hashMap[] = new int[26];
        for(char c : word) {
            hashMap[c - 97] ++;
            if (hashMap[c - 97] == 2) {
                return c;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t>0) {
            String str = sc.nextLine();
            int res = getPosition(str.toCharArray());
            if(res != -1)
                System.out.println((char) res);
            else
                System.out.println(res);
            t--;
        }
    }
}
