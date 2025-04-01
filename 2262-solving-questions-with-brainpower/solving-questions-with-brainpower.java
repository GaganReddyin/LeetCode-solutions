class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            //check if it is not possible to find points after required brainpower
            if(questions[i][1] + i + 1 > n){
                dp[i] = Math.max(dp[i+1], questions[i][0]);
            }
            else{
                //if possible then add in current value and find maximum till now
                 dp[i] = Math.max(dp[i+1], questions[i][0] + dp[i + questions[i][1] + 1]);
            }
        }
        return dp[0];
    }
}