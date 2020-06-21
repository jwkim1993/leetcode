class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        
        int M = dungeon.length, N = dungeon[0].length;
        int[][] essHP = new int[M][N];
        
        //initialize
        essHP[M-1][N-1] = dungeon[M-1][N-1] >= 0 ? 0 : dungeon[M-1][N-1];
        
        for(int i = M-2 ; i >= 0 ; --i) {
            essHP[i][N-1] = essHP[i+1][N-1] + dungeon[i][N-1] >= 0 ? 0 : essHP[i+1][N-1] + dungeon[i][N-1];
        }
        for(int j = N-2 ; j >= 0 ; --j) {
            essHP[M-1][j] = essHP[M-1][j+1] + dungeon[M-1][j] >= 0 ? 0 : essHP[M-1][j+1] + dungeon[M-1][j];
        }
        
        for(int i = M-2; i >=0 ; --i) {
            for(int j = N-2 ; j >= 0; --j) {
                essHP[i][j] = Math.max(
                    essHP[i+1][j] + dungeon[i][j] >= 0 ? 0 : essHP[i+1][j] + dungeon[i][j],
                    essHP[i][j+1] + dungeon[i][j] >= 0 ? 0 : essHP[i][j+1] + dungeon[i][j]);
            }
        }
        
        return -essHP[0][0] + 1;
        
    }
}
