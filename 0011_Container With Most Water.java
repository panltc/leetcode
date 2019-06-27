class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int min = height[i] < height[j] ? height[i++] : height[j--];
            res = Math.max(res, min * (j - i + 1));
        }
        return res;
    }
}
