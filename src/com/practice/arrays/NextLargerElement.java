package com.practice.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextLargerElement {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t!=0) {
            int n = sc.nextInt();
            sc.nextLine();
            Integer arr[] =  Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);
            int res[] = new int[n];

            for(int i=0;i<n;i++) {
                int max = -1;
                int j = i+1;
                while(j<n) {
                    if(arr[j] > arr[i]) {
                        max = arr[j];
                        break;
                    }
                    j++;
                }
                while(i<j) {
                    if (max == -1 )
                        res[i] = -1;
                    else
                        res[i] = max;
                    i++;
                }
                i -=1;
            }

            for (int i=0;i<n;i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}
