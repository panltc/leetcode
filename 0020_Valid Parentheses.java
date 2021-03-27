class Solution {
    public boolean isValid(String s) {
        // 遍历字符串的时候，最外层的括号最后才确定是否匹配，内层的括号先确定是否匹配，适合用栈进行操作
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            /*
             * 遇到左括号，都往栈中压入右括号
             * 遇到右括号，都从栈中弹出一个右括号，如果两个相等，说明这个括号子串正确匹配（在弹出前要先确定栈中是否有元素）
             */
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        // 如果栈空了，说明所有的左括号都确定匹配了，否则，说明有多余的左括号
        return stack.isEmpty();
    }
}
