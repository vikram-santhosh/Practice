package com.practice.stack;

import java.util.Scanner;
import java.util.*;
import java.util.Queue;

class LRU_Cache
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            Set<Integer> s = new HashSet<Integer>() ;
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while(q>0)
            {

                String c = sc.next();
                //	System.out.println(c);
                if(c.equals("GET"))
                {
                    int x = sc.nextInt();
                    System.out.print(g.get(x)+" ");
                }
                if(c.equals("SET"))
                {
                    int x = sc.nextInt();
                    int y  = sc.nextInt();
                    g.set(x,y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*You are required to complete below class */
class LRUCache {
    Map<Integer,Integer> cache;
    Queue<Integer> lru;
    int MAX;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        Map<Integer,Integer> cache = new HashMap<>();
        lru = new LinkedList<>();
        MAX = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        return cache.getOrDefault(x,-1);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        if (! cache.containsKey(x) && cache.size() < MAX) {
            cache.put(x,y);
            lru.add(x);
        }
        if (! cache.containsKey(x) && cache.size() == MAX) {
            lru.poll();
            cache.put(x,y);
            lru.add(x);
        }
        if( cache.containsKey(x)) {
            cache.remove(x);
            cache.put(x,y);
            Queue<Integer> temp = new LinkedList<>(lru);
            lru.clear();
            while(!temp.isEmpty()) {
                int a = temp.poll();
                if (a != x) {
                    lru.add(a);
                }
            }
            lru.add(x);
        }
        lru.forEach(i -> System.out.print(i + " "));
        System.out.println();

    }
}
