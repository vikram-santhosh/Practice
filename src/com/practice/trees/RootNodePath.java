package com.practice.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flinstone on 12-Nov-19.
 */
public class RootNodePath {


    static List<Integer> path = new ArrayList<>();
    public static boolean findPath(Node curr, int val) {
        if (curr == null ) return false;
        if (curr.data == val) return true;

        boolean left = findPath(curr.left, val);
        boolean right = findPath(curr.right, val);
        if(left || right) path.add(curr.data);
        return left || right;
    }
    public static void main(String args[]) {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        int x=8;
        findPath(root, x);
        path.forEach(i -> System.out.print(i + " "));
    }
}
