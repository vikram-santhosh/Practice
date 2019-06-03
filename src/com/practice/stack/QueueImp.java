package com.practice.stack;

import java.util.LinkedList;
import java.util.Queue;

class QueueImp {
    public static void main(String args[]) {
        java.util.Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
