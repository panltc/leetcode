class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] cnts = new int[11];
        for (String word : words) {
            cnts[frequency(word)]++;
        }
        int N = queries.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = frequency(queries[i]) + 1; j <= 10; j++) {
                res[i] += cnts[j];
            }
        }
        return res;
    }
    
    private int frequency(String str) {
        int[] cnts = new int[26];
        int min = 25;
        for (char c : str.toCharArray()) {
            cnts[c - 'a']++;
            min = Math.min(c - 'a', min);
        }
        return cnts[min];
    }
}
