class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // map存储字符以及字符在字符串中的下标
        Map<Character, Integer> map = new HashMap<>();

        // 每次循环都相当于确定了一个新的子串
        for (int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 如果map的key中有当前遍历到的字符，说明该字符已经重复了，滑动左边界
            if (map.containsKey(ch)) {
                /**
                 * 当前字符存在重复时，左边界的滑动要分两种情况。
                 * 1.先出现的字符先产生重复。这种情况下左边界只需要移动到已有重复字符的右一位即可
                 * 2.后出现的字符先产生重复。这种情况下，左边界会先移动到已有重复字符的右一位，
                 * 但是因为map中依然保存了尚未重复出现的字符以及它的下标，所以在后续遍历到这个字符的时候，
                 * 会回跳到map中读取出来的下标的右一位，为了防止回跳，需要比较当前位置和读取下标的右一位，这两个值的最大值
                 */
                i = Math.max(i, map.get(ch) + 1);
            }
            // 将每个遍历到的字符都加入到map中
            map.put(ch, j);
            // i和j的距离就是当前子串的长度
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
