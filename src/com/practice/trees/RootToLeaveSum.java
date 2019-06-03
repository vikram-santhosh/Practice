package com.practice.trees;

import java.util.ArrayList;

public class RootToLeaveSum {

    public static boolean evaluate(Node node, ArrayList<Node> path, int sum) {
        if (node == null) return false;
        else if(node.left == null && node.right == null) {
            if(sum == node.data) {
                path.add(node);
                return true;
            } else {
                return false;
            }
        }
        if(evaluate(node.left, path, sum - node.data) ) {
            path.add(node);
            return true;
        }
        if(evaluate(node.right, path, sum-node.data)) {
            path.add(node);
            return true;
        }
        return false;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(12);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);

        ArrayList<Node> arr = new ArrayList<>();
        int sum = 8;
        evaluate(root, arr, sum);
        arr.forEach( i -> System.out.print(i.data + " "));
    }
}
