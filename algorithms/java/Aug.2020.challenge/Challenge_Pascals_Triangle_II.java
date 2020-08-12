class Solution {
    List<List<Integer>> pasc;
    
    public Solution() {
        pasc = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        pasc.add(tmp);
    }
    
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex >= pasc.size())
            setUntilK(rowIndex);
        
        return pasc.get(rowIndex);
    }
    
    public void setUntilK(int k) {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> kth = pasc.get(pasc.size() - 1);
        
        
        for(int i = pasc.size() - 1 ; i < k ; ++i) {
            tmp.add(1);
            for(int idx = 0 ; idx < kth.size() - 1 ; ++idx) {
                tmp.add(kth.get(idx) + kth.get(idx+1));
            }
            tmp.add(1);
            
            pasc.add(tmp);
            kth = tmp;
            tmp = new ArrayList<>();
        }
    }
}
