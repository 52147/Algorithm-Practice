import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Initialize the queue with all initially rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c, 0}); // (row, column, timestamp)
                } else if (grid[r][c] == 1) {
                    freshOranges += 1;
                }
            }
        }
        
        // Step 2: BFS to rot adjacent fresh oranges
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutesPassed = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];
            minutesPassed = time;
            
            for (int[] dir : directions) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                if (rr >= 0 && rr < rows && cc >= 0 && cc < cols && grid[rr][cc] == 1) {
                    grid[rr][cc] = 2; // mark as rotten
                    freshOranges -= 1;
                    queue.add(new int[]{rr, cc, time + 1});
                }
            }
        }
        
        // If there are still fresh oranges left, return -1
        if (freshOranges > 0) {
            return -1;
        }
        return minutesPassed;
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid3 = {{0, 2}};
        
        System.out.println(solution.orangesRotting(grid1));  // Output: 4
        System.out.println(solution.orangesRotting(grid2));  // Output: -1
        System.out.println(solution.orangesRotting(grid3));  // Output: 0
    }
}
