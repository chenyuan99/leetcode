import java.util.*;

public class MinStack{

Deque<Integer> xStack;
Deque<Integer> minStack;

public MinStack() {
    xStack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
    minStack.push(Integer.MAX_VALUE);
}

public void push(int x) {
    xStack.push(x);
    minStack.push(Math.min(minStack.peek(), x));
}

public void pop() {
    xStack.pop();
    minStack.pop();
}

public int top() {
    return xStack.peek();
}

public int getMin() {
    return minStack.peek();
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}