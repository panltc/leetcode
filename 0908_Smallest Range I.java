class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            min = Math.min(a, min);
            max = Math.max(a, max);
        }
        return min + K < max - K ? max - min - K * 2 : 0;
    }
}
