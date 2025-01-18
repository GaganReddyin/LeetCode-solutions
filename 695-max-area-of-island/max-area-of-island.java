public class Solution {
    private int rows;            // Number of rows in the grid
    private int cols;            // Number of columns in the grid
    private int[][] grid;        // The grid itself

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;             // Set the total number of rows in the grid
        cols = grid[0].length;          // Set the total number of columns in the grid
        this.grid = grid;               // Assign the input grid to the instance variable
        int maxArea = 0;                // To keep track of the maximum area found so far

        // Iterate over every cell in the grid
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                // Update the maximum area after performing DFS on current cell
                maxArea = Math.max(maxArea, dfs(i, j));
            }
        }
        return maxArea;                 // Return the maximum area found
    }

    // Helper method to perform Depth-First Search (DFS)
    private int dfs(int row, int col) {
        // If the current cell is water (0), or it is already visited, then the area is 0
        if (grid[row][col] == 0) {
            return 0;
        }

        int area = 1;                    // Start with a size of 1 for the current land cell
        grid[row][col] = 0;              // Mark the land cell as visited by sinking it (set to 0)
        int[] dirs = {-1, 0, 1, 0, -1};  // Array to represent the four directions (up, right, down, left)

        // Iterate over the four directions
        for (int k = 0; k < 4; ++k) {
            int nextRow = row + dirs[k];      // Calculate the row for adjacent cell
            int nextCol = col + dirs[k + 1];  // Calculate the column for adjacent cell

            // Check if adjacent cell is within the bounds and then perform DFS
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                area += dfs(nextRow, nextCol); // Add the area found from DFS to the total area
            }
        }
        return area;                      // Return the total area found from the current cell
    }
}