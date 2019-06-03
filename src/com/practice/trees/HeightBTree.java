package com.practice.trees;


public class HeightBTree
{
    // Tree node
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            data = data;
            left = null;
            right = null;
        }
    }

    public static int findHeightBTree(Node node) {
        if (node == null)
            return 0;
        int lDepth = findHeightBTree(node.left);
        int rDepth = findHeightBTree(node.right);
        return Math.max(lDepth,rDepth) + 1 ;

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
        System.out.println(findHeightBTree(root));
    }
}
