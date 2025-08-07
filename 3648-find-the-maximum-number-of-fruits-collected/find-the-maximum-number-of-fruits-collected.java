class Solution {
    public int solve(int fruits[][],int i,int j,int dp[][])
    {
        if(i<0||i>=fruits.length||j<0||j>=fruits.length)
        {
            return Integer.MIN_VALUE;
        }
        if(i==j||i>j)
        return Integer.MIN_VALUE;
        if(i==fruits.length-1&&j==fruits.length-1)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int one=fruits[i][j]+solve(fruits,i+1,j-1,dp);
        int two=fruits[i][j]+solve(fruits,i+1,j,dp);
        int three=fruits[i][j]+solve(fruits,i+1,j+1,dp);
        
        return dp[i][j]= Math.max(Math.max(one,two),three);
        
    }
     public int solve2(int fruits[][],int i,int j,int dp[][])
    {
        if(i<0||i>=fruits.length||j<0||j>=fruits.length)
        {
            return Integer.MIN_VALUE;
        }
        
         if(i==j||j>i)
        return Integer.MIN_VALUE;

        if(i==fruits.length-1&&j==fruits.length-1)
        return 0;
        
        if(dp[i][j]!=-1)
        return dp[i][j];

      
      
        int one=  fruits[i][j]+solve2(fruits,i-1,j+1,dp);
        int two=  fruits[i][j]+solve2(fruits,i,j+1,dp);
        int three=  fruits[i][j]+solve2(fruits,i+1,j+1,dp);
        
        
        return dp[i][j]= Math.max(Math.max(one,two),three);
        
    }

    public int maxCollectedFruits(int[][] fruits) 
    {
        int ans=0;

        for(int i=0;i<fruits.length;i++)
        {
            ans+=fruits[i][i];
            fruits[i][i]=-1;
        }
        int dp[][]=new int[fruits.length+1][fruits.length+1];

        for(int i[]:dp)
        Arrays.fill(i,-1);

        ans+=solve(fruits,0,fruits.length-1,dp);
        
        for(int i[]:dp)
        Arrays.fill(i,-1);
        ans+=solve2(fruits,fruits.length-1,0,dp);
        return ans;
        
    }
}