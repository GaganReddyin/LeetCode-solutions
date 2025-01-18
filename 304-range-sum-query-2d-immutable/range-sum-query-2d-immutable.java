class NumMatrix {
    int[][] sumFromOrigin;

    public NumMatrix(int[][] matrix) {
        if(matrix.length==0) return;
        
        sumFromOrigin=new int[matrix.length][matrix[0].length];
        sumFromOrigin[0][0]=matrix[0][0];
        
        for(int c=1;c<matrix[0].length;c++){
            sumFromOrigin[0][c]=sumFromOrigin[0][c -1] + matrix[0][c];
        }
        
        for(int r=1;r<matrix.length;r++){
           sumFromOrigin[r][0]=sumFromOrigin[r-1][0] + matrix[r][0]; 
        }
        
        for(int r=1;r<matrix.length;r++){
          for(int c=1;c<matrix[0].length;c++){
              sumFromOrigin[r][c]=matrix[r][c] + sumFromOrigin[r][c-1] + sumFromOrigin[r-1][c] - sumFromOrigin[r-1][c-1];
          }  
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=sumFromOrigin[row2][col2];
        
        if(row1>0) result-=sumFromOrigin[row1-1][col2];
        if(col1>0) result-=sumFromOrigin[row2][col1-1];
        if(row1>0 && col1>0) result+=sumFromOrigin[row1-1][col1-1];
        
        return result;
    }
}