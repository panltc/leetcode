class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] data = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    data[j] = 1;
                } else {
                    data[j] += data[j - 1];
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(data[i]);
        }
        return res;
    }
}
