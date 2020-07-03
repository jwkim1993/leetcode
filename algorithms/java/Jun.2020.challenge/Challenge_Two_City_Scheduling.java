class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingDouble(c -> c[0] - c[1]));
        
        int retVal= 0;
        int N = costs.length/2;
        for(int i = 0 ; i < N ; i++)
            retVal += costs[i][0] + costs[i+N][1];
        
        return retVal;
    }
}
