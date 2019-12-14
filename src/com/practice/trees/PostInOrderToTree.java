package com.practice.trees;

import java.util.*;

/**
 * Created by Flinstone on 13-Nov-19.
 */
public class PostInOrderToTree {

    static Map<Integer, Integer> inOrderLookup;

    public static class Index {
        int index;
        Index(int index) {this.index = index;}
    }

    public static int getIndex(int t, int[] in) {
        if (inOrderLookup == null) {
            inOrderLookup = new HashMap<>();
            for(int i=0;i<in.length;i++)
                inOrderLookup.put(in[i],i);

        }

        return inOrderLookup.get(t);
    }

    public static Node buildTree(int[] in, int post[], int inStart, int inEnd, Index postIdx) {
        if (inStart > inEnd) return null;
        Node node = new Node(post[postIdx.index--]);
        if ( inStart == inEnd ) return node;
        int inOrderIdx = getIndex(node.data, in);
        node.right = buildTree(in, post, inOrderIdx+1, inEnd, postIdx);
        node.left = buildTree(in, post, inStart, inOrderIdx - 1, postIdx);
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


    public static void main(String args[])
    {
        int in[] = new int[] { 4, 2, 5, 1, 6, 3 };
        //int pre[] = new int[] { 1, 2, 4, 5, 3, 6 };
        int post[] = new int[] {4 , 5, 2, 6, 3, 1};
        int len = in.length;
        Index i = new Index(len - 1);

        Node root = buildTree(in, post, 0, len - 1, i);

        //System.out.println("Inorder traversal of constructed tree is : ");
        inOrder(root);
    }
}
