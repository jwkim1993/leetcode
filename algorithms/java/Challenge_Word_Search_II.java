class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.M = board.length;
        this.N = board[0].length;
        
        List<String> retList = new ArrayList<>();
        
        for(String word: words) {
            char cmp = word.charAt(0);
            for(int i = 0 ; i < M; ++i) {
                for(int j = 0 ; j < N ; ++j) {
                    if(board[i][j] != cmp)
                        continue;
                    
                    if(recurWord(word, 0, i, j)) {
                        retList.add(word);
                        i = M ; j = N; // to break
                    }
                }
            }
        }
        return retList;
    }
    
    public boolean recurWord(String word, int wp, int row, int col) {
        if(wp == word.length())
            return true;
        if(row < 0 || row >= M || col < 0 || col >= N || board[row][col] == '/')
            return false;
        
        if(board[row][col] != word.charAt(wp))
            return false;
        
        board[row][col] = '/';
        boolean retBool = recurWord(word, wp+1, row, col+1) ||
            recurWord(word, wp+1, row, col-1) ||
            recurWord(word, wp+1, row+1, col) ||
            recurWord(word, wp+1, row-1, col);
            
        board[row][col] = word.charAt(wp);
        
        return retBool;        
    }
    
    private char[][] board;
    private int M;
    private int N;
}
