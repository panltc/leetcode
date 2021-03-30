class MyQueue {
    // stack1是输入栈，stack2是输出栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    // 压入新元素的时候，都先存入stack1中
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // 在stack2空的时候，把stack1中全部元素放入stack2中
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    // 如果两个栈都空，才说明队列空了
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
