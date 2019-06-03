package com.practice.trees;

public class LCA_BST {


    public static Node findLCA(Node root, Node n1, Node n2) {
        if(n1.data > root.data && n2.data > root.data) return findLCA(root.right, n1, n2);
        else if (n1.data < root.data && n2.data < root.data) return findLCA(root.left, n1, n2);
        return root;
    }
    // Driver program to test above functions
    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);/*
        root.right.left.right = new LCA.Node(8);
        root.right.right.right = new LCA.Node(9);*/

        Node left = new Node(5);
        Node right = new Node(7);
        System.out.println(findLCA(root, left, right).data);
    }

}
