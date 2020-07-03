class Solution {
    public void sortColors(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        int currIdx = 0;
        
        while(currIdx <= blueIdx) {
            if(nums[currIdx] == 0) {
                nums[currIdx] = nums[redIdx];
                nums[redIdx] = 0;
                ++currIdx; ++redIdx;
            } else if(nums[currIdx] == 2) {
                nums[currIdx] = nums[blueIdx];
                nums[blueIdx] = 2;
                --blueIdx;
            } else {
                ++currIdx;
            }
        }
    }
}
