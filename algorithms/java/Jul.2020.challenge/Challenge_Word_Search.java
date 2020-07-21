class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word.length() == 0)
            return false;
        
        char firstChar = word.charAt(0);
        for(int i = 0 ; i < board.length ; ++i) {
            for(int j = 0 ; j < board[0].length ; ++j) {
                if(board[i][j] == firstChar && recurExist(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean recurExist(char[][] board, int i, int j, String word, int idx) {
        if(word.length() == idx)
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '1')
            return false;
        
        if(board[i][j] != word.charAt(idx))
            return false;
        
        board[i][j] = '1';
        boolean retBool = recurExist(board, i-1, j, word, idx+1) ||
                          recurExist(board, i+1, j, word, idx+1) ||
                          recurExist(board, i, j-1, word, idx+1) ||
                          recurExist(board, i, j+1, word, idx+1);
        
        board[i][j] = word.charAt(idx);
        return retBool;
    }
}
