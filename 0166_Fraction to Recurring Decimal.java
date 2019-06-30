class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator ^ denominator) < 0) {
            sb.append("-");
        }
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(n / d);
        n %= d;
        if (n == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(n, sb.length());
        while (n != 0) {
            n *= 10;
            sb.append(n / d);
            n %= d;
            if (map.containsKey(n)) {
                sb.insert(map.get(n), "(");
                sb.append(")");
                break;
            } else {
                map.put(n, sb.length());
            }
        }
        return sb.toString();
    }
}
