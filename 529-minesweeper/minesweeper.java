class Solution {
    
    // Time Complexity: O(nm)
    // Space Complexity: O(1) extra space
    
    // DFS
    
    int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M') board[row][col] = 'X';
        else dfs(board, row, col);
        return board;
    }
    
    public void dfs(char[][] board, int row, int col) {
        if(board[row][col] != 'E') return;
        int adj = 0;
        for(int[] dir : dirs){
            int r = dir[0];
            int c = dir[1];
            if(inBounds(board, row + r, col + c) && board[row + r][col + c] == 'M') adj++;
        }
        if(adj == 0){
            board[row][col] = 'B';
            for(int[] dir : dirs){
                int r = dir[0];
                int c = dir[1];
                if(inBounds(board, row + r, col + c)) dfs(board, row + r, col + c);
            }
        }else{
            board[row][col] = (char) (adj + '0');
        }
    }
    
    public boolean inBounds(char[][] board, int row, int col){
        return 0 <= row && row < board.length && 0 <= col && col < board[0].length;
    }
    
}