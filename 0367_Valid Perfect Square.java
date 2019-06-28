class Solution {
    public boolean isPerfectSquare(int num) {
        long cur = num;
        while (cur * cur > num) {
            cur = (cur + num / cur) / 2;
        }
        return cur * cur == num;
    }
}
