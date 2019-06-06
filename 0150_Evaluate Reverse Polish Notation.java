class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                if (token.equals("+")) {
                    stack.push(y + x);
                } else if (token.equals("-")) {
                    stack.push(y - x);
                } else if (token.equals("*")) {
                    stack.push(y * x);
                } else {
                    stack.push(y / x);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
