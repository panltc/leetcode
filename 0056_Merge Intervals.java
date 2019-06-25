class Solution {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        int[] lows = new int[N];
        int[] highs = new int[N];
        for (int i = 0; i < N; i++) {
            lows[i] = intervals[i][0];
            highs[i] = intervals[i][1];
        }
        Arrays.sort(lows);
        Arrays.sort(highs);
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < N; i++) {
            if (i == N - 1 || lows[i + 1] > highs[i]) {
                list.add(new int[] {lows[j], highs[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
