package com.practice.stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    public void push(int x) {

        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else{
            int y = min.peek();
            if (x < y) min.push(x);
            else min.push(y);
        }
    }

    public void pop() {
        if (stack.size() > 0){
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return min.isEmpty() ? -1 : min.peek();
    }
}

