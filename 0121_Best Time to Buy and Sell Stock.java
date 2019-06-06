class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(price, min);
            cur = Math.max(price - min, cur);
        }
        return cur;
    }
}
