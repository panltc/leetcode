class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // 用set来保证字符不重复
        Set<Character> set = new HashSet<>();
        // 每次循环都相当于确定了一个新的字串
        for (int i = 0, j = 0; j < s.length(); j++) {
            // 在遍历到一个字符的时候，试着将其加入set中
            while (!set.add(s.charAt(j))) {
                // 如果加入不成功，说明set中已经存在该字符，从开始位置不断remove元素，直到能够加入该元素为止
                set.remove(s.charAt(i++));
            }
            // i和j的距离就是当前字串的长度
            res = Math.max(res, j - i + 1);
        }
        
        return res;
    }
}
