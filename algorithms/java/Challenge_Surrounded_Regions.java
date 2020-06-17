class Solution {
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        
        int rowLen = board.length;
        int colLen = board[0].length;
        
        for(int j = 0; j < colLen; ++j) {
            flip(board, 0, j);
            flip(board, rowLen-1, j);
        }
        
        for(int i = 0; i < rowLen; ++i) {
            flip(board, i, 0);
            flip(board, i, colLen-1);
        }
        
        for(int i = 0 ; i < rowLen; ++i) {
            for(int j = 0 ; j < colLen; ++j) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'C')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void flip(char[][] board, int i, int j) {        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = 'C';
        
        flip(board, i-1, j);
        flip(board, i+1, j);
        flip(board, i, j-1);
        flip(board, i, j+1);
    }
}
