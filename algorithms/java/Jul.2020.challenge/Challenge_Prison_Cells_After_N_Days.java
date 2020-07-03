class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells == null || cells.length < 3 || N == 0)
            return cells;
        
        N = N%14 != 0 ? N%14 : 14;
        
        int cellLen = cells.length;
        int[] futureCells = new int[cellLen];
        for(int day = 0 ; day < N ; ++day) {
            for(int i = 1 ; i < cellLen-1; ++i) {
                futureCells[i] = (cells[i-1]^cells[i+1])^0x1;
            }
            cells = futureCells;
            futureCells = new int[cellLen];
        }
        
        return cells;
    }
}
