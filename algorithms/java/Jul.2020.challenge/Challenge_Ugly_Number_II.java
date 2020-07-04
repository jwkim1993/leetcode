class Solution {
  
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
     
      return ugly.nums[n-1];
      
    }
}

class Ugly {
  
  int[] nums;
  
  public Ugly(){
    nums = new int[1690];
    nums[0] = 1;
    int i2 = 0, i3 = 0, i5 = 0;
    for(int i=1;i<1690;i++){
      
      nums[i] = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);
      
      if(nums[i]==nums[i2]*2) i2++;
      if(nums[i]==nums[i3]*3) i3++;
      if(nums[i]==nums[i5]*5) i5++;
    }
  }
  
}
