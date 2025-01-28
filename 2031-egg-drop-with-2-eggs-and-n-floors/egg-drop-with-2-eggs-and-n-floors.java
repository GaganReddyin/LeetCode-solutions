class Solution {
    Integer[][] memo;
    public int twoEggDrop(int n) {
        int k = 2;
        memo = new Integer[n + 1][k + 1];
        return helper(n, k);
    }

    private int helper(int n, int k){
        if(n == 0) return 0;
        if(k == 1) return n;
        if(memo[n][k] != null) return memo[n][k];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            res = Math.min(res, 1 + Math.max(helper(i - 1, k - 1), helper(n - i, k)));
        }
        return memo[n][k] = res;
    }
}