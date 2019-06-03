package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Leader {


    public  static  void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int e=0;e<t;e++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


            if (arr.length > 1) {
                for (int i = 0; i < n; i++) {
                    boolean isLeader = true;
                    for (int j = i + 1; j < n; j++) {
                        if (arr[j] > arr[i]) {
                            isLeader = false;
                            break;
                        }
                    }
                    if (isLeader) sb.append(arr[i] + " ");
                }
                sb.append("\n");
            } else sb.append(arr[0] + " ");
        }
        System.out.println(sb);
    }
}
