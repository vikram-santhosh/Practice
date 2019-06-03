package com.practice.trees;


class BinaryTree
{
    Node root;

    class BalancedTree {
        boolean isBalanced;
        int height;
        BalancedTree(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
            System.out.println(isBalanced + " -> " + height);
        }
    }

    public BalancedTree evaluate(Node node) {
        if (node == null) {
            return new BalancedTree(true, -1);
        }

        BalancedTree leftResult = evaluate(node.left);
        if(!leftResult.isBalanced) return leftResult;
        BalancedTree rightResult = evaluate(node.right);
        if(!rightResult.isBalanced) return  rightResult;

        System.out.print(node.data + " -> ");

        boolean checkLeftAndRight = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalancedTree(checkLeftAndRight, height);
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.left.left = new Node(10);
        tree.root.left.left.left.left.left = new Node(12);

        if(tree.evaluate(tree.root).isBalanced)
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}