class Solution {
    int[][] pad = new int[][] {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
    int[][] dirs = new int[][] {{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{1,2},{2,1}};
    long[][] dp;    
    int modulus = (int)Math.pow(10,9)+7;
    long sol = 0;
    public int knightDialer(int n) {
        dp = new long[n+1][10];
        for(int r = 0; r<pad.length; r++){
            for(int c = 0; c<pad[0].length; c++){
                sol = (sol+helper(r,c,n))%modulus;
            }
        }
        return (int) sol;
    }
    public long helper(int r, int c, int n){
        if (n == 1 && validMove(r,c)){
            return 1;
        }
        if(!validMove(r,c)){
            return 0;
        }
        if(dp[n][pad[r][c]]>0){
            return dp[n][pad[r][c]];
        }
        long curr = 0;
        for(int[] d : dirs){
            int newR = d[0]+r;
            int newC = d[1]+c;
            curr = (curr+helper(newR,newC,n-1))%modulus;
        }
        dp[n][pad[r][c]] = curr;
        return curr;
    }
    public boolean validMove(int r, int c){
        if (r<0 || c<0 || r>=pad.length || c>=pad[0].length || pad[r][c] == -1){
            return false;
        }return true;
    }
}