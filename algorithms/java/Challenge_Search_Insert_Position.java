class Solution {
    public int searchInsert(int[] nums, int target) {
        int ret = Arrays.binarySearch(nums, target);
        return ret >= 0 ? ret : -ret - 1;
    }
}
