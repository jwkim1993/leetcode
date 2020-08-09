class Solution {
    int N;
    int M;
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        
        this.N = grid.length;
        this.M = grid[0].length;
        for(int i = 0 ; i < N ; ++i) {
            for(int j = 0 ; j < M ; ++j) {
                if(grid[i][j] != 2)
                    continue;
                
                grid[i][j] = 3;
                dfs(grid, j, i, 2);
            }
        }
        
        int maxVal = 0;
        for(int i = 0 ; i < N ; ++i) {
            for(int j = 0 ; j < M ; ++j) {
                if(grid[i][j] == 1)
                    return -1;
                if(maxVal < grid[i][j])
                    maxVal = grid[i][j];
            }
        }
        
        return maxVal == 0 ? 0 : maxVal - 2;
    }
    
    public void dfs(int[][] grid, int x, int y, int rottenLevel) {
        if(x < 0 || x >= M || y < 0 || y >= N || grid[y][x] == 0 || 
           (grid[y][x] >= 2 && grid[y][x] <= rottenLevel))
            return;
        
        grid[y][x] = rottenLevel;
        
        dfs(grid, x-1, y, rottenLevel + 1);
        dfs(grid, x+1, y, rottenLevel + 1);
        dfs(grid, x, y-1, rottenLevel + 1);
        dfs(grid, x, y+1, rottenLevel + 1);
    }
}
