class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        // starts是起点的集合，ends是终点的集合
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        /*
         * starts和ends此时无序，先对两个数组进行排序
         * 未确定的起点和下一个起点之间至多只有一个终点，如果只有一个终点，说明两个区间出现了间隔，否则，说明两个区间产生了重叠
         * i指针用来确定区间的右边界，会不断右移来扩大右边界范围
         * j指针用来确定区间的左边界，每确定一个区间，j指针就会移动到i + 1的位置，也就是下个区间的左边界
         * starts[i + 1]和ends[i]进行比较，是因为每一个未确定的起点都对应一个终点，所以下一个区间的左边界一定要和最右的右边界进行比较
         */
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();

        for (int i = 0, j = 0; i < len; i++) {
            if (i == len - 1 || starts[i + 1] > ends[i]) {
                list.add(new int[] {starts[j], ends[i]});
                j = i + 1;
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}
