package com.practice.trees;
public class LCA
{
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

    public static Node findLCA(Node root, Node n1, Node n2) {
        if (root == null ) return null;
        else if (root.data == n1.data || root.data == n2.data) return root;
        Node leftResult = findLCA(root.left, n1, n2);
        Node rightResult = findLCA(root.right, n1, n2);
        if (leftResult != null && rightResult != null) return root; // propogating result
        else if (leftResult == null && rightResult == null) return null;
        return (leftResult == null ? rightResult : leftResult);
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

        Node left = new Node(5);
        Node right = new Node(9);
        System.out.println(findLCA(root, left, right).data);
    }
}
