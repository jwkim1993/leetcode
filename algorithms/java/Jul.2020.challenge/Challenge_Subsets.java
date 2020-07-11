class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        
        for(int i = 0 ; i < nums.length ; ++i) {
            addSubset(nums[i], retList);
        }
        
        return retList;
    }
    
    
    public void addSubset(int add, List<List<Integer>> pastSubset) {
        
        int N = pastSubset.size();
        for(int i = 0 ; i < N ; ++i) {
            pastSubset.add(new ArrayList<>(pastSubset.get(i)));
            pastSubset.get(i+N).add(add);
        }
    }
}
