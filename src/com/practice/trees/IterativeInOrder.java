package com.practice.trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder
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

    public static void inOrder(Node node){
        Stack<Node> stack = new Stack<>();
        //stack.push(node);
        Node curr = node;
        List<Node> inOrder = new ArrayList<>();
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inOrder.add(curr);
            curr = curr.right;
        }
        inOrder.forEach(item -> System.out.print(item.data + " "));

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
        inOrder(root);
    }
}
