class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] retArr = new int[k+1];
        int[] count = new int[k+1];
        
        int i = 0;
        int prev = nums[0];
        while(i < nums.length) {
            int curCount = 0;
            while(i < nums.length && nums[i] == prev) {
                ++i;
                ++curCount;
            }
            
            int idx = k-1;
            for(; idx >= 0 && count[idx] < curCount; --idx) {
                retArr[idx+1] = retArr[idx];
                count[idx+1] = count[idx];
            }
            retArr[idx+1] = prev;
            count[idx+1] = curCount;
            
            prev = i < nums.length ? nums[i] : 0;
        }
        
        return Arrays.copyOf(retArr, k);
    }
}
