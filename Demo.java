import java.util.*;

public class Demo {
    static void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = '0';
        q.offer(new int[] {row, col});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            for(int i=0 ; i<4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1') {
                    grid[nr][nc] = '0';
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }

    static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }
}