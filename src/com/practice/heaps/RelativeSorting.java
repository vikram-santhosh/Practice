package com.practice.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class RelativeSorting {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0 ) {
            String vals[] = br.readLine().split("\\s+");
            int m  = Integer.parseInt(vals[0]);
            int n = Integer.parseInt(vals[1]);

            int a[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int b[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            StringBuffer out = new StringBuffer();
            int lookup[] = new int[100000];
            for (int i=0; i<m; i++) {
                lookup[a[i]] ++;
                heap.add(a[i]);
            }

            for(int i=0; i<n; i++) {
                if(lookup[b[i]] > 0 ) {
                    for (int j = 0; j < lookup[b[i]]; j++) {
                        out.append(b[i] + " ");
                        heap.remove(b[i]);
                    }
                }
            }

            Iterator it = heap.iterator();
            while (it.hasNext()) out.append(heap.poll() + " ");


            System.out.println(out);
            t--;
        }

    }
}
