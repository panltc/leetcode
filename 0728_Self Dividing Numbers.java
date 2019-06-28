class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i)) {
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean isSelfDividingNumbers(int i) {
        int tmp = i;
        while (i > 0) {
            if (i % 10 == 0 || tmp % (i % 10) != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
