package com.practice.arrays;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class KadanesAlgo {

    public static int solve(int A, int B, List<Integer> C) {
        Stack<Integer> st  = new Stack<Integer>();
        //int num_pass = 0;
        System.out.println("Starting ...");

        st.push(B);
        for(int i=0; i < C.size(); i++) {
            //System.out.println("Start : " + C.get(i));
            if ( C.get(i) == 0) {
                //System.out.println("0 ==>" +  C.get(i));

                int t = 0;
                while ( i < C.size() && C.get(i) == 0  ) {
                    t += 1;
                    i++;
                    //System.out.println("Count " + t);

                }
                //System.out.println("Outsize  " + C.get(i));

                if ( i < C.size() ) i--;
                if ( t % 2 !=0 ) {
                    int x = st.pop();
                    //System.out.println("Removing " + x);

                }

            } else {
                st.push(C.get(i));
            }
        }
        return st.pop();
    }
/*    public static int solve(List<Integer> arr) {

        int globalMax = arr.get(0) , currMax = arr.get(0);
        for(int i=1;i<arr.size(); i++) {
            currMax = Math.max( arr.get(i) , currMax + arr.get(i));
            globalMax = Math.max(globalMax, currMax);
        }
        return globalMax;
    }*/
    public static void main (String[] args) {
        //int n, m;
        //Scanner sc = new Scanner(System.in);
       // n = sc.nextInt();
        //List<Integer> arr = Arrays.asList(23,86,63,60,0,47,0,99,9,0,0);
        List<Integer> arr = Arrays.asList(79,0,0,63,0,32,45,0,83,0);
        int res = solve(10, 23, arr);
        System.out.println(res);

    }/*        for(int i=0;i<n;i++) {
            m = sc.nextInt();
            sc.nextLine();
            //List<Integer> arr = Stream.of(sc.nextLine().split("\\s+")).map(Integer::valueOf).collect(toList());

        }*/
}