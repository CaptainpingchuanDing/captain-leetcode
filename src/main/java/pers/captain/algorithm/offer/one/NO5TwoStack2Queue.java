package pers.captain.algorithm.offer.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class NO5TwoStack2Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    @Test
    public void test() {
        NO5TwoStack2Queue queue = new NO5TwoStack2Queue();
        queue.push(2);
        queue.push(3);
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.pop());
    }

    public void push2(int node) {
        stack1.push(node);
    }

    public int pop2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    @Test
    public void test2() {
        NO5TwoStack2Queue queue = new NO5TwoStack2Queue();
        queue.push2(2);
        queue.push2(3);
        Assert.assertEquals(2, queue.pop2());
        Assert.assertEquals(3, queue.pop2());
    }
}
