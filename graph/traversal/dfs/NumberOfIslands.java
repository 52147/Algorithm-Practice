package graph.traversal.dfs;

public class NumberOfIslands {
    
    // Function to count the number of islands in a grid
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is '1', it's a part of an island
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Use DFS to mark all cells in this island as visited
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    // Helper function for Depth First Search (DFS)
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check for boundaries and if the cell is water or already visited
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark the cell as visited by setting it to '0'
        grid[i][j] = '0';

        // Recursively visit all adjacent cells (up, down, left, right)
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }

    // Main method to test the solution
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result); // Output: 3
    }
}

