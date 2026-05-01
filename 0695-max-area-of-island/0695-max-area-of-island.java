class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int maxArea = 0;
              int rows = grid.length;
                      int cols = grid[0].length;

                              for (int r = 0; r < rows; r++) {
                                          for (int c = 0; c < cols; c++) {
                                                          // If we find land, calculate the area of that island
                                                                          if (grid[r][c] == 1) {
                                                                                              maxArea = Math.max(maxArea, dfs(grid, r, c));
                                                                                                              }
                                                                                                                          }
                                                                                                                                  }
                                                                                                                                          return maxArea;
                                                                                                                                              }

                                                                                                                                                  private int dfs(int[][] grid, int r, int c) {
                                                                                                                                                          // Base case: Out of bounds or hitting water/already visited land
                                                                                                                                                                  if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
                                                                                                                                                                              return 0;
                                                                                                                                                                                      }

                                                                                                                                                                                              // Mark current cell as visited by turning it to 0
                                                                                                                                                                                                      grid[r][c] = 0;

                                                                                                                                                                                                              // Current cell (1) + area of all 4 neighbors
                                                                                                                                                                                                                      return 1 + dfs(grid, r + 1, c) + 
                                                                                                                                                                                                                                         dfs(grid, r - 1, c) + 
                                                                                                                                                                                                                                                            dfs(grid, r, c + 1) + 
                                                                                                                                                                                                                                                                               dfs(grid, r, c - 1);  
    }
}