class Solution {
    public int maxCount(int m, int n, int[][] ops) {
		int max = m*n;
        if (ops.length > 0){
            int minIndexX = ops[0][0];
            int minIndexY = ops[0][1];
            for(int i=0; i<ops.length; i++) {
                minIndexX = Math.min(minIndexX, ops[i][0]);
                minIndexY = Math.min(minIndexY, ops[i][1]);
                max = minIndexX * minIndexY;
            }
        }
        return max;
    }
}