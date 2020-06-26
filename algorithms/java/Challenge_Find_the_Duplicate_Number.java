class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 2)
            return nums[0];
        
        int i = 0;
        while(nums[i] > 0) {
            nums[i] *= -1;
            i = -nums[i];
        }
        
        return i;
    }
}
