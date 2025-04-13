class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long odd = fun(4, n / 2, mod);
        long even = fun(5, n - n / 2, mod);
        return (int)((odd * even) % mod);
    }
    
    public long fun(long x, long y, long mod){
        if (y == 0) {
            return 1;
        }
        long half = fun(x, y / 2, mod);
        half = (half * half) % mod;
        if (y % 2 != 0) {
            half = (half * x) % mod;
        }
        return half;
    }
}