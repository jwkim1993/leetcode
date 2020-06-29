class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return nums[0] < nums[1] ? nums[1] : nums[0];
        
        int N = nums.length;
        return Math.max(dp(nums, 0, N-2), dp(nums, 1, N-1));
    }
    
    public int dp(int[] nums, int start, int end) {
        int[] dpRes = new int[nums.length];
        dpRes[start] = nums[start];
        dpRes[start+1] = Math.max(nums[start], nums[start+1]);
        
        for(int i = start+2 ; i <= end; ++i) {
            dpRes[i] = Math.max(dpRes[i-2]+nums[i], dpRes[i-1]);
        }
        
        return dpRes[end];
    }
}
