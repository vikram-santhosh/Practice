package com.practice.strings;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAdjDups {

    public static String removeAdjDups(String str) {
        StringBuffer sb = new StringBuffer();
        List<Character> arr = str.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
        arr.add(' ');
        int start = 0;
        for(int i=0;i<arr.size();i++){
            if (arr.get(i) == arr.get(i+1)) {
                start = i;
                while(arr.get(i) == arr.get(i+1)){
                    i++;
                }
                arr.subList(start,i+1).clear();
                i = start;
            }
        }

        arr.forEach(i -> sb.append(i));
        return sb.toString();
    }
    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- !=0) {
            String str = br.readLine();
            System.out.println(removeAdjDups(str));
        }

    }
}

