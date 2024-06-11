import java.util.Stack;

class MaxStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(maxStack.peek())) {
            maxStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println(maxStack.getMax()); // Output: 5
        maxStack.pop();
        System.out.println(maxStack.getMax()); // Output: 3
    }
}
