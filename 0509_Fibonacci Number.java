class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= N; i++) {
            int tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;
    }
}
