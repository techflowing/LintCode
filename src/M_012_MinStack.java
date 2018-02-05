import java.util.Stack;

/**
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 */
public class M_012_MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public M_012_MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty()) {
            minStack.push(number);
        } else {
            // 这里考虑的相等的情况也会继续push
            if (minStack.peek() >= number) {
                minStack.push(number);
            }
        }
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
