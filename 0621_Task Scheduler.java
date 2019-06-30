class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        for (char task : tasks) {
            cnts[task - 'A']++;
        }
        Arrays.sort(cnts);
        int res = (cnts[25] - 1) * (n + 1);
        for (int i = 25; i >= 0; i--) {
            if (cnts[i] != cnts[25]) {
                break;
            }
            res++;
        }
        return Math.max(tasks.length, res);
    }
}
