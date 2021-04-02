class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double data = x;
        double tmp = x;

        /*
         * 牛顿迭代法求解，在确定一个初值后，不断迭代以求出该函数的零点，因此需要构造零点为sqrt(x)的函数
         * 函数表达式为y = d ^ 2 - x（x为常数），初值点设置为(di, yi)
         * 过初值点做切线，切线表达式为：y - yi = 2di * (d - di)
         * 得y - (di ^ 2 - x) = 2di * (d - di)
         * 因为要求零点，所以y = 0，得：d = (di + x / di) / 2;
         * d即为下一次迭代的初值，记为di+1
         * di+1和di之间的差值小于某个极小的值（例如1e-7）就可以认为求得该解了，终止迭代
         */
        while (true) {
            data = (data + x / data) / 2;
            if (Math.abs(data - tmp) < 1e-7) {
                break;
            }
            tmp = data;
        }
        
        return (int) data;
    }
}
