class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int res = 1;
        for (int i = 3, max = (int)Math.sqrt(n); i < n; i += 2) {
            if (prime[i]) {
                res++;
                if (i > max) {
                    continue;
                }
                for (int j = i * i; j < n; j += i * 2) {
                    prime[j] = false;
                }
            }
        }
        return res;
    }
}
