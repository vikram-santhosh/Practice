package com.practice.trees;

import java.util.*;

/**
 * Created by Flinstone on 14-Nov-19.
 */
public class SerializeDeserialize {

    public static String serialize(Node root) {
        if( root == null ) return "X,";
        return root.data + "," + serialize(root.left) + serialize(root.right);
    }
    public static Node deserialize(String str) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
        return utils(queue);
    }

    public static Node utils(Queue<String> nodes) {
        String nodeVal = nodes.poll();
        if (nodeVal.equals("X")) return null;

        Node node = new Node(Integer.parseInt(nodeVal));
        node.left = utils(nodes);
        node.right = utils(nodes);
        return node;
    }

    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();

        Node curr = root;
        while(stack.size() != 0 || curr != null){
            while ( curr != null ) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            arr.add(curr.data);
            curr = curr.right;
        }
        arr.forEach(i -> System.out.print(i + " "));
        System.out.println();
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

        String serializedTree = serialize(root);
        System.out.println(serializedTree);
        Node d = deserialize(serializedTree);
        inOrder(d);

    }
}
