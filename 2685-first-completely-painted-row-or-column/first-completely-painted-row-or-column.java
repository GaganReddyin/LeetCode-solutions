class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int size = arr.length;
        int n = mat.length;
        int m = mat[0].length;
        //Implement a HashMap and store row and column value for each item
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                map.put(mat[i][j], new ArrayList<Integer>(Arrays.asList(i,j)));
            }
        }
        
        //now make arrays of row and column of size column and row respectively for getting the filled size of that row or that column.
        int[] row = new int[n];
        int[] col = new int[m];
        int rval = Integer.MAX_VALUE;
        int cval =Integer.MAX_VALUE;
        
        // for each value of arr we increase the filled size by one and check if any row or col filled size equals to col or row size respectively and store the minimum index.
        for(int i = 0;i<size;i++)
        {
            int val = arr[i];
            int r=map.get(val).get(0);
            int c=map.get(val).get(1);
            row[r]++;
            if(row[r]==m) rval = Math.min(rval,i);
            col[c]++;
            if(col[c]==n) cval = Math.min(cval,i);
            
        }
        return Math.min(rval,cval);
    }
}