class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int data = 0;
        while (data < x) {
            data = data * 10 + x % 10;
            x /= 10;
        }
        return data == x || data / 10 == x;
    }
}
