package com.practice.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Flinstone on 09-Jun-19.
 */
public class DisjointSet {

    Map<Integer, Node> lookup = new HashMap<>();
    class Node {
        int data;
        Node parent;
        int rank;
    }

    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        lookup.put(data, node);
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public int findSet(int data) {
        return findSet(lookup.get(data)).data;
    }

    public void union(int x, int y) {
        Node A = lookup.get(x);
        Node B = lookup.get(y);

        Node leader_A = findSet(A);
        Node leader_B = findSet(B);

        if (leader_A == leader_B) return;

        if (leader_A.rank > leader_B.rank ) {
            leader_B.parent = leader_A;
        } else if (leader_B.rank > leader_A.rank){
            leader_A.parent = leader_B;
        } else {
            leader_A.rank = leader_A.rank + 1;
            leader_B.parent = leader_A;
        }
    }


    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        //ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
