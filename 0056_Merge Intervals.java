class Solution {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        int[] begins = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(begins);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < N; i++) {
            if (i == N - 1 || begins[i + 1] > ends[i]) {
                list.add(new int[] {begins[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
