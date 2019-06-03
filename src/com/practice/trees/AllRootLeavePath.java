package com.practice.trees;

import java.util.ArrayList;

public class AllRootLeavePath {

    public static void evaluate(Node node, ArrayList<Node> path, ArrayList<ArrayList<Node>> paths) {

        if (node != null) {
            path.add(node);
            if(node.left == null && node.right == null) {
                paths.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            else {
                evaluate(node.left, path, paths);
                evaluate(node.right, path, paths);
                path.remove(path.size()-1);
            }
        }
    }

    public static void print(Node[] nodes, int n) {
        for(int i=0; i<n; i++) {
            System.out.print(nodes[i].data + " ");
        }
        System.out.println();
    }

    public static void evaluate1(Node node, Node[] nodes, int idx) {

        if (node != null) {
            nodes[idx++] = node;
            if(node.left == null && node.right == null) {
                print(nodes,idx);
            }
            else {
                evaluate1(node.left, nodes, idx);
                evaluate1(node.right, nodes, idx);
            }
        }
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(12);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);

        ArrayList<ArrayList<Node>> paths = new ArrayList<>();
        ArrayList<Node> path = new ArrayList<>();
        /*evaluate(root, path, paths);
        paths.forEach( i -> {
            i.forEach( j -> System.out.print(j.data + " ") );
            System.out.println();
        });*/

        evaluate1(root, new Node[1000], 0);
    }
}
