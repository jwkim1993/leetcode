class Solution {
    Set<Coordi> visited = new HashSet<>();
    
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
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
                if(board[i][j] != 'X' && !visited.contains(new Coordi(i, j)))
                    board[i][j] = 'X';
            }
        }
    }
    
    public void flip(char[][] board, int i, int j) {        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
           || board[i][j] == 'X' || visited.contains(new Coordi(i, j)))
            return;
        
        visited.add(new Coordi(i, j));
        
        flip(board, i-1, j);
        flip(board, i+1, j);
        flip(board, i, j-1);
        flip(board, i, j+1);
    }
    
    class Coordi {
        int i;
        int j;
        public Coordi(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int hashCode() {
            return i+j;
        }
        
        @Override
        public boolean equals(Object obj) {
            Coordi coordi;
            if(obj instanceof Coordi)
                coordi = (Coordi) obj;
            else
                return false;
            
            if(this.i == coordi.i && this.j == coordi.j)
                return true;
            return false;
        }
        
        @Override
        public String toString() {
            return String.format("(%d, %d)", i, j);
        }
        
    }
}
