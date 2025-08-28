class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length; int m=grid[0].length;
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int key=i-j;
                if(!map.containsKey(key)) {
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(grid[i][j]);
            }
        }

        for(int key:map.keySet()) {
            if(key<0) {
                ArrayList list=map.get(key);
                Collections.sort(list);
                map.put(key,list);
            } else {
                ArrayList list=map.get(key);
                Collections.sort(list,Collections.reverseOrder());
                map.put(key,list);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int key=i-j;
                grid[i][j]=map.get(key).get(0);
                map.get(key).remove(0);
            }
        }
        return grid;
    }
}