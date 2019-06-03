package com.practice.trees;

public class IdenticalTrees {


    public boolean isIdentical(Node nodeA, Node nodeB) {
        if(nodeA == null && nodeB == null) return true;
        if(nodeA.data == nodeB.data ) return  (isIdentical(nodeA.left, nodeB.left) && isIdentical(nodeA.right, nodeB.right));
        return false;
    }

    public static void main(String args[]) {
        IdenticalTrees identicalTrees = new IdenticalTrees();

        Node rootA = new Node(1);
        rootA.left = new Node(2);
        rootA.right = new Node(3);
        rootA.left.left = new Node(12);
        rootA.left.right = new Node(5);
        rootA.left.left.left = new Node(8);

        Node rootB = new Node(1);
        rootB.left = new Node(2);
        rootB.right = new Node(3);
        rootB.left.left = new Node(4);
        rootB.left.right = new Node(5);
        rootB.left.left.left = new Node(8);

        System.out.println(identicalTrees.isIdentical(rootA, rootB));
    }
}
