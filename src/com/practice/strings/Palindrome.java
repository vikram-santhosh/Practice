package com.practice.strings;

public class Palindrome {
    public static int isPalindrome(String A) {
        System.out.println( A.replaceAll("[^A-Za-z0-9]", ""));
        char[] ch = A.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r) {
            if(ch[l] != ch[r]) return 0;
            l ++ ;
            r -- ;
        }
        return 1;
    }

    public static void main(String args[]) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}

