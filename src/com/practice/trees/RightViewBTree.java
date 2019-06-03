package com.practice.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RightViewBTree {
    void rightView(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        StringBuffer output = new StringBuffer();
        while(!nodes.isEmpty()){
            int levelCount = nodes.size();
            int nodeCount = nodes.size();
            while(nodeCount != 0 ) {
                Node node = nodes.poll();
                if(Objects.nonNull(node.left)) nodes.add(node.left);
                if(Objects.nonNull(node.right)) nodes.add(node.right);
                nodeCount -- ;
                if(nodeCount == 0) output.append(node.data + " ");
            }
        }
        System.out.print(output);
    }
}
