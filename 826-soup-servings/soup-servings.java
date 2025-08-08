class Solution {
    private double[][] memo;
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;

        int N = (n + 24) / 25; 
        memo = new double[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                memo[i][j] = -1.0; 
            }
        }
        return dfs(N, N);
    }
    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5; // both empty
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first
        if (memo[a][b] != -1.0) return memo[a][b];

        double res = 0.0;
        res += dfs(a - 4, b);            
        res += dfs(a - 3, b - 1);         
        res += dfs(a - 2, b - 2);         
        res += dfs(a - 1, b - 3);        
        res *= 0.25; 

        memo[a][b] = res;
        return res;
    }

}