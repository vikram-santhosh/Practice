package com.practice.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Flinstone on 18-Nov-19.
 */
class IPAddress{
    public static Set<String> genIp(String s){
        Set<String> res = new HashSet<>();
        List<String> ip = new ArrayList<>();
        backtrack(s, ip, res, 0, 4);
        return res;
    }

    public static void backtrack(String input, List<String> ip, Set<String> res, int start, int k) {

       if (k == 0) {
            String s = String.join(".",ip);
            if (s.length() == input.length()+3) {
                res.add(s);
                return;
            }
       }


        for(int i=start; i<input.length(); i++) {
            for (int width=1; width<3; width++) {
                if(start+width <= input.length()) {
                    String sub = input.substring(start, start+width);
                    if (Integer.parseInt(sub) <= 255 ) {
                        ip.add(sub);
                        backtrack(input, ip, res, start+width, k-1);
                    }
                    ip.remove(ip.size()-1);
                }
                //
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >= 0) {
            String n = sc.nextLine();
            Set<String> res = genIp(n);
            res.forEach(i -> System.out.println(i));
        }
    }
}