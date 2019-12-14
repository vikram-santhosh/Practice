package com.practice.trees;

import java.util.*;

/**
 * Created by Flinstone on 12-Nov-19.
 */
public class BinaryTreeViews {

    public static List<Integer> getLeftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (root != null) queue.add(root);
        while(queue.size() != 0) {
            int levelSize = queue.size();
            int count = 0;
            while(count != levelSize) {
                Node curr = queue.poll();
                if (count == 0) res.add(curr.data);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                count ++;
            }
        }
        return res;
    }

    public static List<Integer> getRightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (root != null) queue.add(root);
        while(queue.size() != 0) {
            int levelSize = queue.size();
            int count = 0;
            while(levelSize != count) {
                Node curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                count ++;
                if (count == levelSize) res.add(curr.data);
            }
        }
        return res;
    }

    public static void verticalSortUtils(Node node, int hd, TreeMap<Integer, List<Node>> tMap) {
        if (node != null) {
            List<Node> nodes = tMap.get(hd);
            if (nodes == null) {
                nodes = new ArrayList<>();
                nodes.add(node);
                tMap.put(hd, nodes);

            } else {
                nodes.add(node);
            }
            verticalSortUtils(node.left, hd - 1, tMap);
            verticalSortUtils(node.right, hd + 1, tMap);
        }
    }


    public static List<Integer> getTopView(Node root) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
        int hd = 0;
        verticalSortUtils(root, hd, treeMap);
        treeMap.forEach((k, v) -> res.add(v.get(0).data));
        return res;
    }

    public static List<List<Integer>> spiralOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Stack<Node> forward = new Stack<>();
        Stack<Node> backward = new Stack<>();

        if(root != null) forward.push(root);

        while (forward.size() != 0 || backward.size() != 0) {
            List<Integer> forwardList = new ArrayList<>();
            List<Integer> backwardList = new ArrayList<>();

            while(forward.size() != 0) {
                Node node = forward.pop();
                forwardList.add(node.data);
                if (node.left != null) backward.add(node.left);
                if (node.right != null) backward.add(node.right);
            }

            while(backward.size() != 0) {
                Node node = backward.pop();
                backwardList.add(node.data);
                if (node.right != null) forward.add(node.right);
                if (node.left != null) forward.add(node.left);
            }

            if(forwardList.size()!= 0) res.add(forwardList);
            if(backwardList.size()!= 0) res.add(backwardList);
        }
        return res;
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

        getLeftView(root).forEach( i -> System.out.print(i + " "));
        System.out.println();

        getRightView(root).forEach(i -> System.out.print(i + " "));
        System.out.println();

        getTopView(root).forEach(i -> System.out.print(i + " "));
        System.out.println();

        spiralOrder(root).forEach(i -> {
            i.forEach( j -> System.out.print(j + " "));
            System.out.println();
        });
    }
}
