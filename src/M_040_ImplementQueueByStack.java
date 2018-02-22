import java.util.Stack;

/**
 * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
 * <p>
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * <p>
 * pop和top方法都应该返回第一个元素的值。
 */
public class M_040_ImplementQueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public M_040_ImplementQueueByStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.empty()) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}
