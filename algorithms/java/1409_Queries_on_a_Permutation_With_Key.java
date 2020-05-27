class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> permu = new ArrayList<>();
        for(int i= 1 ; i <= m ; ++i)
            permu.add(i);
        
        int[] retList = new int[queries.length];
        int idx = 0;
        
        for(int i = 0 ; i < queries.length ; ++i) {
            Integer query = queries[i];
            retList[idx++] = permu.indexOf(query);
            permu.remove(query);
            permu.add(0, query);
        }
        
        return retList;
    }
}
