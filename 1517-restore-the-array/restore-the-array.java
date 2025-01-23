class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfArrays(String s, int k) {
        var N = s.length();
        var dp = new int[N + 1];
        dp[0] = 1;

        for (var i = 0; i < N; ++i) {
            if (s.charAt(i) == '0') continue;

            long n = 0;
            for (var j = i + 1; j <= N; ++j) {
                n = n * 10 + (s.charAt(j - 1) - '0');

                if (n > k) break;

                dp[j] = (dp[j] + dp[i]) % MOD;
            }
        }

        return dp[N];
    }
}