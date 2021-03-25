class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        /*
         * 动态规划方程：f(n) = max(f(n - 1), price - min)
         * f(n)：第n天的最大利润
         */
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }

        return res;
    }
}
