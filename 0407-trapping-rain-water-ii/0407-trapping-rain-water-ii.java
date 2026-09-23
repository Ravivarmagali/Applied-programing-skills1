import java.util.PriorityQueue;

class Solution {
    private static class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the Min-Heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int totalWater = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Process cells starting from the lowest boundary wall
        while (!minHeap.isEmpty()) {
            Cell curr = minHeap.poll();

            for (int[] dir : directions) {
                int r = curr.row + dir[0];
                int c = curr.col + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    // Trapped water is determined by the boundary height minus current cell height
                    totalWater += Math.max(0, curr.height - heightMap[r][c]);
                    // Push neighbor with the effective updated water level (max height)
                    minHeap.offer(new Cell(r, c, Math.max(heightMap[r][c], curr.height)));
                }
            }
        }

        return totalWater;
    }
}