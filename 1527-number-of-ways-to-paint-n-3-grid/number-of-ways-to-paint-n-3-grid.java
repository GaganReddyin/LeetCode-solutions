class Solution {
    public static final int MOD = (int)(1e9 + 7);
    public int numOfWays(int n) {
        //We will have two types of pattern 010 and 012
        //All think of differentiating disjoint factors

        //Now dp definition is dp[0]--->c0--> number of ways of ending with pattern p1
        // dp[1] ---> c1 ---> number of ways of ending with pattern p2
        // temp = c0
        //c0 = 3 * c0 + 2 * c1
        //c1 = 2 * temp + 2 * c1
        long c0 = 6;
        long c1 = 6;
        
        for(int i = 2 ; i <= n ; ++i){
            long temp = c0;
            c0 = ((3 * c0) % MOD + (2 * c1)%MOD) % MOD;
            c1 = ((2 * temp) % MOD + (2 * c1) % MOD) % MOD;
        }
        return (int)((c0 + c1) % MOD);
    }
}