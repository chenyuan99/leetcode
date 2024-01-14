public class NumberOfIslands{

    public static void dfs(int[][] grid, int r, int c){

        if (!inArea(grid, r, c)) {
            return;
        }


        grid[r][c] = 2; 

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    

    }
    
    public static boolean inArea(int[][] grid, int r, int c){
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}

// can we make changes on the grid ditrctly