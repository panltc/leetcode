class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        // 只要第二天的价格大于第一天，就进行一次买卖
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }
}
