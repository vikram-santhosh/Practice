package com.practice.trees;
// Java program for printing vertical order of a given binary tree

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderBtree
{
    // Tree node
    static class Node
    {
        int key;
        Node left;
        Node right;

        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }

    static void getVerticalOrder(Node node, TreeMap<Integer, List<Integer>> tMap, int hd){
        if (node == null)
            return;
        List<Integer> column = tMap.get(hd);
        if(column == null) {
            column = new ArrayList<>();
            column.add(node.key);
            tMap.put(hd, column);

        }else {
            column.add(node.key);
        }

        getVerticalOrder(node.left, tMap, hd-1);
        getVerticalOrder(node.right, tMap, hd+1);
    }

    static void printVerticalOrder(Node root) {
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<Integer, List<Integer>>();
        int hd = 0;
        getVerticalOrder(root, tMap, hd);

        tMap.forEach((key, values) -> {
            StringBuffer sb = new StringBuffer();
            values.forEach(i -> sb.append(i + " "));
            System.out.println(sb);
        });
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
