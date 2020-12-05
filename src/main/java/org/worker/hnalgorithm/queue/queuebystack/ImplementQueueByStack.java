package org.worker.hnalgorithm.queue.queuebystack;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class ImplementQueueByStack {

    public static void main(String[] args) {
        ImplementQueueByStack queue = new ImplementQueueByStack();
        queue.push(2);
        queue.push(1);
        queue.push(3);
        queue.push(5);
        while(!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
