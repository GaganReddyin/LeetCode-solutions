class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        for(int i = 0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if((i==heights.length-1 && j==0) || (i==0 && j==heights[0].length-1)){
                    res.add(Arrays.asList(i,j));
                    continue;
                }
                boolean[] pair = new boolean[2];
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                dfs(heights,i,j,pair,visited,heights[i][j]);
                if(pair[0] && pair[1]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void dfs(int[][] heights,int i,int j,boolean[] pair,boolean[][] visited,int prev){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || visited[i][j] == true || heights[i][j] > prev) return;
        if(i == 0 || j==0) pair[0] = true;
        if(i == heights.length-1 || j == heights[0].length-1) pair[1] = true;
        if(pair[0] && pair[1]) return;
        prev = heights[i][j];
        visited[i][j] = true;
        dfs(heights,i-1,j,pair,visited,prev);
        dfs(heights,i,j+1,pair,visited,prev);
        dfs(heights,i+1,j,pair,visited,prev);
        dfs(heights,i,j-1,pair,visited,prev);
    }
}