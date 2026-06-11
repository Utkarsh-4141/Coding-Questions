package Graph;

public class NumberOfIslandsDFS { // O(m × n) & O(m × n)
    static void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if(row<0 || row>=m ||
            col<0 || col>=n ||
            grid[row][col] == '0') {
                return;
        }

        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }
}

// Number of Islands = Connected Components in a grid.

// DFS Approach:
// For every cell:
// if(grid[i][j] == '1')
// Increment island count.
// DFS from that cell.
// Mark all connected land cells visited.
// Direction Arrays

// Instead of writing:
// up, down, left, right
// separately, use:
// int[] row = {-1, 1, 0, 0};
// int[] col = {0, 0, -1, 1};

// '1' = Land & '0' = Water

// Example
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 1 0 0
// 0 0 0 1 1
// Islands:
// Island 1:
// 1 1
// 1 1
// Island 2:
// 1
// Island 3:
// 1 1

// Why Mark Cells as '0'?
// Instead of using:
// boolean[][] visited
// we directly modify grid.
// Example:
// grid[row][col] = '0';
// Meaning: Already visited, Saves extra memory.

// Largest Island Size:
// Instead of: count++;
// Return size from DFS.
// Track: maxSize

// If diagonal connections are allowed -> 8 Directions
// Use:
// int[] dr =
// {-1,-1,-1,0,0,1,1,1};
// int[] dc =
// {-1,0,1,-1,1,-1,0,1};