package Solution1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-05-18
 */
public class MinStack {
    Stack<Integer> stack;
    Queue<Integer> pq;

    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.add(x);
        pq.add(x);
    }

    public void pop() {
        pq.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return pq.peek();
    }
}
