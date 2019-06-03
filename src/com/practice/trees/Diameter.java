package com.practice.trees;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Diameter
{
    // Tree node
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int findHorizontalDist(Node node) {
        Queue<Node> nodes = new LinkedList <>();
        Map<Node,Integer> hd = new HashMap<>();
        nodes.add(node);
        hd.put(node, 0);
        while(!nodes.isEmpty()) {
            Node curr = nodes.poll();
            if(curr.left != null) {
                nodes.add(curr.left);
                hd.put(curr.left, hd.get(curr)-1);
            }
            if(curr.right != null) {
                nodes.add(curr.right);
                hd.put(curr.right, hd.get(curr)+1);
            }
        }
        int maxWidth = -1;
        int minWidth = 999999;
        for(int i : hd.values()) {
            maxWidth = Math.max(i, maxWidth);
            minWidth = Math.min(i, minWidth);
        }
        return minWidth*-1 + maxWidth;
    }


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
        System.out.println(findHorizontalDist(root));
    }
}
