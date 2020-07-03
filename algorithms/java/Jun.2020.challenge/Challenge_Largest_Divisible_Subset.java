class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<Integer>();
        else if(nums.length == 1)
            return new ArrayList<Integer>(List.of(nums[0]));
        
        Arrays.sort(nums);
        
        int N = nums.length;
        int[] c = new int[N];
        int[] dp = new int[N];
        Arrays.fill(c, 1);
        int maxVal = -1;
        int maxIdx = -1;
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i]%nums[j] == 0 && c[i] <= c[j] + 1) {
                    c[i] = c[j]+1;
                    dp[i] = j;
                }
            }
            if(c[i] > maxVal) {
                maxVal = c[i];
                maxIdx = i;
            }
        }
        
        List<Integer> retList = new ArrayList<>();
        for(int i = 0; i < maxVal; i++) {
            retList.add(nums[maxIdx]);
            maxIdx = dp[maxIdx];
        }
        
        return retList;
    }
}
