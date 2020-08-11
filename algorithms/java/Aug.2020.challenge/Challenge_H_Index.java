class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int N = citations.length;
        
        if(N == 0 || citations[N-1] == 0)
            return 0;
        if(N == 1 || citations[0] >= N)
            return N;
        
        for(int i = N-1 ; i > 0; --i){
            if(citations[N-i] >= i)
                return i;
        }
        
        return 0;
    }
}
