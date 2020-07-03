class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0 or len(board[0]) == 0:
            return;
        
        rowLen = len(board)
        colLen = len(board[0])
        
        for j in range(colLen):
            self.flip(board, 0, j)
            self.flip(board, rowLen - 1, j)
        
        for i in range(rowLen):
            self.flip(board, i, 0)
            self.flip(board, i, colLen - 1)
        
        for i in range(rowLen):
            for j in range(colLen):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'C':
                    board[i][j] = 'O'
                    
    def flip(self, board: List[List[str]], i: int, j: int) -> None:
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or not board[i][j] == 'O':
            return
        
        board[i][j] = 'C'
        
        self.flip(board, i-1, j)
        self.flip(board, i+1, j)
        self.flip(board, i, j-1)
        self.flip(board, i, j+1)
