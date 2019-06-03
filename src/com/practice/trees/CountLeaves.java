package com.practice.trees;
import java.util.*;

public class CountLeaves
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

    public static List<Node> inOrder(Node node){
        Node curr = node;
        Stack<Node> stack = new Stack<>();
        List<Node> nodes = new LinkedList<>();
        while(Objects.nonNull(curr) || !stack.isEmpty()) {
            while(Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodes.add(curr);
            curr = curr.right;
        }
        return nodes;
    }

    public static int countLeaves(Node root) {
        List<Node> nodes = inOrder(root);
        int count = 0 ;
        for(Node node: nodes) {
            if(node.left == null && node.right == null)
                count ++;
        }
        return count;
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
        System.out.println(countLeaves(root));
    }
}
