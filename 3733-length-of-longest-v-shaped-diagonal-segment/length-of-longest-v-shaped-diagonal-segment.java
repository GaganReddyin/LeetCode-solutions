class Solution {
    int n ,m;
    int[][] grid;
    int[][] dirs = {{1,1},{-1,-1},{1,-1},{-1,1}};

    public int lenOfVDiagonal(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;

        int ans = 0;

        // check each cell for start point (1)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    for(int d= 0;d<4;d++){
                        ans = Math.max(ans, dfs(i,j,d,false,2));
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int dir, boolean hasTurned, int expect){
        int len = 1;
        int x = i+dirs[dir][0];
        int y = j+dirs[dir][1];

        // straight ahead
        if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == expect){
            int nextExpect = (expect==2 ? 0 : (expect == 0 ? 2 : -1));
            len = Math.max(len, 1 + dfs(x,y,dir,hasTurned, nextExpect));
        }

        if(!hasTurned){
            for(int nd=0;nd<4;nd++){
                if(nd != dir && isClockWiseTurn(dir,nd)){
                    x = i+dirs[nd][0];
                    y = j+dirs[dir][1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == expect){
                        int nextExpect = (expect == 2 ? 0 : (expect == 0 ? 2 : -1));
                        len = Math.max(len, 1+ dfs(x,y,nd,true, nextExpect));
                    }
                }
            }
        }
        return len;
    }

    private boolean isClockWiseTurn(int d1, int d2){
        int[] order = {0,2,1,3};
        for(int k=0;k<4;k++){
            if(order[k] == d1){
                return order[(k+1)%4] == d2;
            }
        }
        return false;
    }
}

