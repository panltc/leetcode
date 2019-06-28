class Solution {
    public int bitwiseComplement(int N) {
        int cur = 1;
        while (cur < N) {
            cur = cur * 2 + 1;
        }
        return cur - N;
    }
}
