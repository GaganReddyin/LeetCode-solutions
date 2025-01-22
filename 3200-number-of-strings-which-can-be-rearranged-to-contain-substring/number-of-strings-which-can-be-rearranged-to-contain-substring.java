class Solution {
    long[][][][] memo;
    public long dp(int n, int l, int e, int t) {        
        if (n == 0) 
            return l <= 0 && e <= 0 && t <= 0 ? 1 : 0;
        
        l = Math.max(l, 0);
        e = Math.max(e, 0);
        t = Math.max(t, 0);

        if (memo[n][l][e][t] != 0) return memo[n][l][e][t];

        long result = 23 * dp(n - 1, l, e, t)
            + dp(n - 1, l-1, e, t)
            + dp(n - 1, l, e-1, t)
            + dp(n - 1, l, e, t-1);

        return memo[n][l][e][t] = result % 1000_000_007;
    }
    public int stringCount(int n) {
        this.memo = new long[n+1][2][3][2];
        return (int) dp(n, 1, 2, 1);
    }
}