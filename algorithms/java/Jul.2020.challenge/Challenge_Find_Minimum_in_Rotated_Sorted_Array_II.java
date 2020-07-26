class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        
        // fully sorted
        if(nums[start] < nums[end])
            return nums[start];
        
        int mid = 0;
        while(start < end) {
            mid = (start+end)/2;
            //pivot is in right-side
            if(nums[mid] > nums[end])
                start = mid+1;
            //pivot is in left-side
            else if(nums[mid] < nums[start])
                end = mid;
            else
                --end;
        }
        
        return nums[start];
    }
}
