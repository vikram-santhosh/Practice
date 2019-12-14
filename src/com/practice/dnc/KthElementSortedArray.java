package com.practice.dnc;


import java.util.Scanner;
import java.util.stream.Stream;

public class KthElementSortedArray {

    public static Scanner sc = new Scanner(System.in);

    public static int solve(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k) {

        if (end2 == start2) return arr1[k];
        else if (start1 == end1) return arr2[k];

        int mid1 = (start1+end1)/2;
        int mid2 = (start1+end2)/2;

        if (mid1 + mid2 < k) {
            /**
             * Need to expand the search perimeter.
             * if arr1[mid1] < arr2[mid2], all elements between [start1,mid1] are less than arr2[mid] and can be removed
             * simultaneously, the value of k should reflect the moved elements k => k - mid1 - 1
             */
            if(arr1[mid1] < arr2[mid2]) return solve(arr1,mid1+1, end1, arr2, start2, end2, k-(mid1-start1+1));
            else return solve(arr1,start1, end1, arr2, mid2+1, end2, k-(mid2-start2+1));
        }
        else {
            if(arr1[mid1] > arr2[mid2]) return solve(arr1, start1, mid1, arr2, start2, end2, k);
            else return solve(arr1, start1, end1, arr2, start2, mid2, k);
        }
    }

    public static void main (String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- != 0) {
            int[] opts = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int[] arr1
                    = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int[] arr2 = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int end1 = opts[0];
            int end2 = opts[1];
            int k = opts[2];
            System.out.println(solve(arr1, 0, end1, arr2, 0, end2, k-1));
        }
    }
}