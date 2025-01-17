class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            } else if (move == 'D') {
                y--;
            } else {
                y++;
            }
        }
        return x == 0 && y == 0;
    }
}
