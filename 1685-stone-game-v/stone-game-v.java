class Solution {
    Integer[][] dp;
    public int stoneGameV(int[] stoneValue) {
        dp = new Integer[stoneValue.length][stoneValue.length];
        int total = 0;
        for(int x:stoneValue){
            total+=x;
        }
        return solve(stoneValue,0,stoneValue.length-1,total);
    }

    private int solve(int[] stones,int i,int j,int total){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int sum=0, result=0;
        for(int k=i;k<=j;k++){
            sum+=stones[k];
            int max = 0;
            if(2*sum<total){
                max = sum+solve(stones,i,k,sum);
            }
            else if(2*sum>total){
                max = total-sum + solve(stones,k+1,j,total-sum);
            }
            else{
                max = Math.max(sum+solve(stones,i,k,sum), total-sum+solve(stones,k+1,j,total-sum));
            }
            result = Math.max(max,result);
        }
        return dp[i][j] = result;
    }
}