class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                int x = stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x + y);
                res += x + y;
            } else if (op.equals("D")) {
                res += stack.push(stack.peek() * 2);
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
