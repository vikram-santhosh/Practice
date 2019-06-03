package com.practice.trees;
import java.util.*;


/*class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class LevelOrder {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        if(root == null) return;
        StringBuffer output = new StringBuffer();
        nodes.add(root);

        while(! nodes.isEmpty()) {
            Node node = nodes.poll();
            output.append(node.data + " ");
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }

        System.out.println(output);

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}