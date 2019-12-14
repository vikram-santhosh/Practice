package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Flinstone on 29-Oct-19.
 */
public class Permutation {

    public static List<String> permute(char arr[]) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean used[] = new boolean[arr.length];
        int start = 0;
        backtrack(arr, used, sb, res);
        return res;
    }

    public static void backtrack(char[] arr, boolean[] used, StringBuffer sb, List<String> res) {
        if(sb.length() == arr.length) {
            res.add(sb.toString());
        } else {
            for(int i=0; i<arr.length; i++) {
                /**
                 * i>0 && arr[i] == arr[i-1] && !used[i-1]
                 * This statement is need to preserve order in in the event that arr[i] == arr[i-1]
                 */
                if (used[i] || ( i>0 && arr[i] == arr[i-1] && !used[i-1])) continue;
                else {
                    sb.append(arr[i]);
                    used[i] = true;
                    backtrack(arr, used, sb, res);
                    sb.deleteCharAt(sb.length()-1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        String str = "abc";
        List<String> res = permute(str.toCharArray());
        res.forEach( p -> System.out.println(p));
    }
}
