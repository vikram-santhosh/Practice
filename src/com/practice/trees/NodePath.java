package com.practice.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flinstone on 13-Nov-19.
 */
public class NodePath {

    public static class Height {
        int val;
    }
    public static boolean isHeightBalanced(Node root, Height height) {
        Height lHeight = new Height();
        Height rHeight = new Height();

        if(root == null) {
            height.val = 0;
            return true;
        }
        boolean left = isHeightBalanced(root.left, lHeight);
        boolean right = isHeightBalanced(root.right, rHeight);

        height.val = Math.max(lHeight.val, rHeight.val) + 1;
        return (left && right && Math.abs(lHeight.val - rHeight.val) <= 1);
    }

    public static Node findLCA(Node root, Node n1, Node n2) {
        if (root == null) return null;
        if (root.data == n1.data || root.data == n2.data) return root;
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
        if(left != null && right != null) return root;
        if(left != null || right != null) return left != null ? left : right;
        return null;
    }

    public static int findDist(Node source, Node target, int level) {
        if (source == null) return -1;
        if (source.data == target.data) return level;
        int left = findDist(source.left, target, level + 1);
        int right = findDist(source.right, target, level + 1);
        return left == -1 ? right : left;
    }

    public static boolean findPath(Node source, Node target, List<Integer> res) {
        if (source == null) return false;
        else if (source.data == target.data) {
            res.add(source.data);
            return true;
        }
        else if (findPath(source.left, target, res) || findPath(source.right, target, res)) {
            res.add(source.data);
            return true;
        }
        return false;
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
        //root.right.right.right.right = new Node(10);

        Node x = new Node(8);
        Node y = new Node(9);

        Node lca = findLCA(root, x, y);
        int d1 = findDist(lca, x, 0);
        int d2 = findDist(lca, y, 0);

        List<Integer> path = new ArrayList<>();

        findPath(lca, x, path);

        path.forEach(i -> System.out.println(i));
        System.out.println("LCA = " + lca.data);
        System.out.println("D1 = " + d1);
        System.out.println("D2 = " + d2);

        System.out.println(d1+d2);

        System.out.println(isHeightBalanced(root, new Height()));
    }

}
