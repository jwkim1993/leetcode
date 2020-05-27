class NumArray {
    int[] dynmNums;
    
    public NumArray(int[] nums) {
        dynmNums = new int[nums.length + 1];
        dynmNums[0] = 0;
        for(int i = 1 ; i <= nums.length ; ++i) {
            dynmNums[i] = dynmNums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return dynmNums[j+1] - dynmNums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
