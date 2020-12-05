package org.worker.hnalgorithm.stack.minstack;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> element;
    private Stack<Integer> minStack;

    public MinStack() {
        this.element = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        this.element.push(x);
        if(this.minStack.size() == 0) {
            this.minStack.push(x);
        }else {
            if(x < this.minStack.peek()) {
                this.minStack.push(x);
            }else {
                this.minStack.push(this.minStack.peek());
            }
        }
    }

    public void pop() {
        this.minStack.pop();
        this.element.pop();
    }

    public int top() {
        return this.element.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}
