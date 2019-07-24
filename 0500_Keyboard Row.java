class Solution {
    public String[] findWords(String[] words) {
        int[] lines = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char cur = word.charAt(0);
            int line = cur >= 'A' && cur <= 'Z' ? lines[cur - 'A'] : lines[cur - 'a'];
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c - 'A' + 'a');
                }
                if (lines[c - 'a'] != line) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
