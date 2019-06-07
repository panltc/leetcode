class Solution {
    public String toLowerCase(String str) {
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 'A' && data[i] <= 'Z') {
                data[i] += 'a' - 'A';
            }
        }
        return String.valueOf(data);
    }
}
