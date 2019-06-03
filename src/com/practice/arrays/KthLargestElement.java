package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class KthLargestElement {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < t; idx++) {
            String[] vals = br.readLine().split("\\s+");
            int k = Integer.parseInt(vals[0]);
            int n = Integer.parseInt(vals[1]);
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                if (minHeap.size() < k) {
                    minHeap.add(arr[i]);
                } else if (minHeap.size() == k && arr[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
                if (minHeap.size() < k) System.out.print(-1 + " ");
                else System.out.print(minHeap.peek() + " ");
            }
            System.out.println();

        }
    }
}
