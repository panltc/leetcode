class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] res = new int[N + 1];
        int i = 0;
        int j = N;
        for (int k = 0; k < N; k++) {
            res[k] = S.charAt(k) == 'I' ? i++ : j--;
        }
        res[N] = i;
        return res;
    }
}
