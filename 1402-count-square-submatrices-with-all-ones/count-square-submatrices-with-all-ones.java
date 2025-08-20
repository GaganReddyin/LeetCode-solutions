class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    count++;
                    int maxsize=Math.min(matrix.length-i,matrix[0].length-j);
                    for(int size=2;size<=maxsize;size++){
                        if(issquare(matrix,i,j,size)){
                            count++;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
    public boolean issquare(int[][] matrix,int r,int c,int size){
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                if(matrix[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}