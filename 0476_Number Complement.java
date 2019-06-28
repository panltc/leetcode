class Solution {
    public int findComplement(int num) {
        int cur = 0;
        while (cur < num) {
            cur = cur * 2 + 1;
        }
        return cur - num;
    }
}
