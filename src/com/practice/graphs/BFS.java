package com.practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 09-Jun-19.
 */
public class BFS {

    public static void isCyclePresent() {

    }

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int edges[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int N = arr[0];
            int E = arr[1];

            // construct adj list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
            for (int i = 0; i < edges.length; i += 2) {
                adj.get(edges[i]).add(edges[i + 1]);
                adj.get(edges[i + 1]).add(edges[i]);
            }
        }
    }
}
