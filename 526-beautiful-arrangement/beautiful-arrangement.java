class Solution {
    int [] dp = new int[1<<17];
    public int countArrangement(int n) {
        Arrays.fill(dp, -1); 
        dp[(1<<n+1)-1] = 1;
        return dfs(1, n, 1);
    }
    public int dfs(int mask, int n, int v) {
        if (dp[mask]!=-1) return dp[mask];
        int ret = 0;
        for (int i = 1; i<=n; i++) {
            if (((mask>>i) & 1) != 1) {
                if (i%v==0 || v%i==0) {
                    ret += dfs(mask|(1<<i), n, v+1);
                }
            }
        }
        dp[mask] = ret;
        return ret;
    }
}