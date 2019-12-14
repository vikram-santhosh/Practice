package com.practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 08-Jun-19.
 *
 * Input:
 First line of input contains number of testcases T. For each testcase. First line of each testcase contains number of nodes and edges seperated by space and next line contains N pairs of integers (X and Y each) where X Y means an edge from X to Y.

 Output:
 For each testcase, print the nodes while doing DFS starting from node 0.
 */
public class DFS {

    public static void recurrsiveDFS(List<List<Integer>> adj, int node, int N) {
        boolean visited[] = new boolean[N];
        System.out.print(node + " ");
        visited[node] = true;
        for( int i : adj.get(node)) {
            if( !visited[i]) {
                recurrsiveDFS(adj, i, N);
            }
        }
    }


    public static void dfs(List<List<Integer>> adj, int node, int N) {
        boolean visited[] = new boolean[N];
        StringBuffer sb = new StringBuffer();
        Stack<Integer> st = new Stack<>();
        st.push(node);
        visited[node] = true;
        while(!st.isEmpty()) {
            node = st.pop();
            sb.append(node + " ");
            for (int x : adj.get(node)) {
                if(!visited[x]) {
                    st.push(x);
                    visited[x] = true;
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int edges[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int N = arr[0];
            int E = arr[1];

            // construct adj list
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0; i<N; i++) adj.add(new ArrayList<>());
            for(int i=0;i<edges.length;i+=2) {
                adj.get(edges[i]).add(edges[i+1]);
            }
            //dfs(adj,0, N);
            recurrsiveDFS(adj,0,N);
        }
    }
}
