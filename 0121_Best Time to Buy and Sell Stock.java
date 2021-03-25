class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        // 动态规划方程：F[i] = MAX(price - min, F[i - 1])
        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(price - min, res);
        }

        return res;
    }
}
