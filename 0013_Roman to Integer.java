// solution 1
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'I') {
                res += res < 5 ? 1 : -1;
            } else if (c == 'V') {
                res += 5;
            } else if (c == 'X') {
                res += res < 50 ? 10 : -10;
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'C') {
                res += res < 500 ? 100 : -100;
            } else if (c == 'D') {
                res += 500;
            } else {
                res += 1000;
            }
        }
        return res;
    }
}

// solution 2
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int N = s.length();
        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            char c = s.charAt(i);
            res += map.get(c) < map.get(s.charAt(i + 1)) ? -map.get(c) : map.get(c);
        }
        res += map.get(s.charAt(N - 1));
        return res;
    }
}
