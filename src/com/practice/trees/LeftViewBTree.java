package com.practice.trees;
import java.util.*;
import java.lang.Integer;

public class LeftViewBTree {

    public static List<Integer> leftView(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int levelCount = nodes.size();
            int count = nodes.size();
            while (count != 0) {
                Node node = nodes.poll();
                if(levelCount == count) result.add(node.data);
                if(node.left != null) nodes.add(node.left);
                if(node.right != null) nodes.add(node.right);
                count --;
            }
        }
        return result;
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
        leftView(root).forEach( i -> System.out.print(i + " "));
    }
}