package Graph;

import java.util.*;

public class NumberOfIslandsBFS { // O(m × n) & O(m × n)
    static void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int i=0 ; i<4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<grid.length &&
                    nc>=0 && nc<grid[0].length &&
                    grid[nr][nc] == '1') {
                        grid[nr][nc] = '0';
                        queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
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

// Number of Provinces:
// Difference:
// Graph Input
// instead of
// Matrix Grid
// Same connected-components idea.