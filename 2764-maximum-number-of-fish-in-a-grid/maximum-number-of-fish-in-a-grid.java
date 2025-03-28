class Solution {
    private final List<Integer[]> directions = List.of(
            new Integer[]{1, 0}, new Integer[]{-1, 0}, new Integer[]{0, 1}, new Integer[]{0, -1}
    );

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) maxFish = Math.max(maxFish, dfs(i, j, grid));
            }
        }
        return maxFish;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (notValid(i, j, grid) || grid[i][j] == 0) return 0;
        int fish = grid[i][j];
        grid[i][j] = 0;
        for (Integer[] direction: directions) {
            int x = i + direction[0], y = j + direction[1];
            fish += dfs(x, y, grid);
        }
        return fish;
    }

    private boolean notValid(int i, int j, int[][] grid) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }
}