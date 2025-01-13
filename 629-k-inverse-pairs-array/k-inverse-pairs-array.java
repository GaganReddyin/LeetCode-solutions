class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            int[] newDp = new int[k + 1];
            int sum = 0;
            for (int j = 0; j <= k; j++) {
                sum = (sum + dp[j]) % mod;
                if (j >= i) {
                    sum = (sum - dp[j - i]);
                    if (sum < 0) sum += mod;
                }
                newDp[j] = sum;
            }
            dp = newDp;
        }
        return dp[k];
    }
}