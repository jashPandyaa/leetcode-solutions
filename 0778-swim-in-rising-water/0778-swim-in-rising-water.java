import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        // Priority queue: [row, col, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        
        // Start from top-left corner
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            // If we reached bottom-right corner
            if (row == n - 1 && col == n - 1) {
                return time;
            }
            
            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n 
                    && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    // Time needed is max of current time and the elevation at new cell
                    int newTime = Math.max(time, grid[newRow][newCol]);
                    pq.offer(new int[]{newRow, newCol, newTime});
                }
            }
        }
        
        return -1; // Should never reach here
    }
}