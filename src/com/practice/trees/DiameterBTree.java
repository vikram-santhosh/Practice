package com.practice.trees;

/**
 * Created by Flinstone on 12-Nov-19.
 */
public class DiameterBTree {

    public static class Height {
        int val;
    }
    public static int findDiameter(Node root, Height height) {

        Height lHeight = new Height();
        Height rHeight = new Height();

        if (root == null) {
            height.val = 0;
            return 0;
        }
        int lDiameter = findDiameter(root.left, lHeight);
        int rDiameter = findDiameter(root.right, rHeight);

        height.val = Math.max(lHeight.val , rHeight.val) + 1;

        return Math.max(Math.max(lDiameter, rDiameter), (lHeight.val + rHeight.val + 1));

    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);

        System.out.println(findDiameter(root, new Height()));
    }
}
