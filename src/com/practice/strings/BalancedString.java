package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedString {

    public static String isExpBalanced(String exp){
        char[] chars = exp.toCharArray();
        Map<Character,Character> lookup = new HashMap<>();

        lookup.put('(',')');
        lookup.put('[',']');
        lookup.put('{','}');

        Stack<Character> st = new Stack<>();
        for(char ch: chars) {
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                char elementInStack =  st.pop();
                if (lookup.get(elementInStack) != ch ) return "not balanced";
            }
        }
        if (st.empty()) return "balanced";
        else  return "not balanced";
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String exp = br.readLine();
            System.out.println(isExpBalanced(exp));
        }
    }
}
