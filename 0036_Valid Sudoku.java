class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(i + "r: " + c) || !set.add(j + "c: " + c) || !set.add(i / 3 + ", " + j / 3 + "b: " + c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
