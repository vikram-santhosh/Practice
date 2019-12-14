package com.practice.trees;

/**
 * Created by Flinstone on 12-Nov-19.
 */
public class BinaryTreeToList {

    static Node head = null;
    static Node prev = null;

    public static void transform(Node curr) {
        if (curr == null) return;

        transform(curr.left);

        if (prev == null) head = curr;
        else {
            curr.left = prev;
            prev.right = curr;
        }
        prev = curr;

        transform(curr.right);
    }

    public static void print(Node head) {

        Node x, y = null;
        x = head;

        while(x != null) {
            System.out.print(x.data + " ");
            if (x.right == null) y = x;
            x = x.right;

        }
        System.out.println();
        while(y != null ) {
            System.out.print(y.data + " ");
            y = y.left;
        }
    }


    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        transform(tree.root);
        print(head);

        // Print the converted List
        //tree.printList(tree.head);

    }
}
