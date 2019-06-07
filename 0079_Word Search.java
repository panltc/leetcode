class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] = '#';
        boolean b = 
            backtrack(board, i - 1, j, word, k + 1) || 
            backtrack(board, i + 1, j, word, k + 1) || 
            backtrack(board, i, j - 1, word, k + 1) ||
            backtrack(board, i, j + 1, word, k + 1);
        board[i][j] = word.charAt(k);
        return b;
    }
}
