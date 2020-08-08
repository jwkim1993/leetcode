class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        for(int idx : nums) {
            if(nums[Math.abs(idx)-1] < 0)
                retList.add(Math.abs(idx));
            else
                nums[Math.abs(idx)-1] *= -1;
        }
        
        return retList;
    }
}
