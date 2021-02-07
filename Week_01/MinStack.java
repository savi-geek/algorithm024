import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linaluo
 * @date 2021/1/29 10:48 上午
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class MinStack {

    Deque<Integer> numStack = null;
    Deque<Integer> minStack  = null;
    public MinStack() {
        numStack = new LinkedList();
        minStack = new LinkedList();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        numStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        numStack.pop();
        minStack.pop();
    }

    public int top() {
        int top = numStack.peek();
        return top;
    }

    public int getMin() {
        int min = minStack.peek();
        return min;
    }
}
