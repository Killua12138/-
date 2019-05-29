package jianzhi;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        min.push(min.isEmpty() ? node : Math.min(node,min.peek()));
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
