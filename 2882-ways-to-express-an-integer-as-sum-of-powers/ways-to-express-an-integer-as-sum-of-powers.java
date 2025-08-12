class Solution {
    int numberOfWays = 0;
    public int numberOfWays(int n, int x) {
        numberOfWays = 0;
        long mod = 1000000007;
        if(n == 0) {
            return 0;
        }
        if(x == 0) {
            return n;
        }
        ArrayList<Long> nPowerXList = new ArrayList<>();
        long niPowerX = 0;
        int iSum = 0;
        int index = 1;
        for(int i =0; ; i++) {
            niPowerX = (long) Math.pow(i, x);
            if(niPowerX > n){
                break;
            }
            nPowerXList.add( niPowerX);
        }
        long[][] dp = new long[nPowerXList.size()][n+1];
        dp[0][0] = 1;
        for(int row = 1; row < nPowerXList.size(); row++) {
            int iNum = Math.toIntExact(nPowerXList.get(row));
            for (int col = 0; col <= n; col++) {
                if(iNum > col) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    dp[row][col] = (dp[row - 1][col] + dp[row - 1][col - iNum]) % mod;
                }
            }
        }
        return (int) dp[nPowerXList.size()-1][n];
    }

    private void getNumberOfWays(ArrayList<Long> nPowerXList, int n, int iSum, int index) {
        if(n == iSum) {
            numberOfWays++;
            return;
        }
        if(index >= nPowerXList.size() || iSum > n) {
            return;
        }

        getNumberOfWays(nPowerXList, n, (int) (iSum + nPowerXList.get(index)), index + 1);
        getNumberOfWays(nPowerXList, n, iSum, index + 1);
    }
}