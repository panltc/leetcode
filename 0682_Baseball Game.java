class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int x = stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x + y);
                res += stack.peek();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
                res += stack.peek();
            } else if (op.equals("C")) {
                res -= stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
                res += stack.peek();
            }
        }
        return res;
    }
}
