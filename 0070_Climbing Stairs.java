class Solution {
    public int climbStairs(int n) {
        // 爬一个台阶只有一种方法
        if (n == 1) {
            return 1;
        }

        int prev = 1;
        int res = 2;
        
        /* 动态规划方程：f(n) = f(n - 1) + f(n - 2)
         * f(n)：爬n个台阶的方法。
         * prev相当于f(n - 2)
         */
        for (int i = 3; i <= n; i++) {
            int tmp = res;
            res += prev;
            prev = tmp;
        }

        return res;
    }
}
