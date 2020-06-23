class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for(int num : nums) {
            if(!dict.containsKey(num))
                dict.put(num, 0);
            dict.put(num, dict.get(num)+1);
        }
        
        for(int key: dict.keySet()) {
            if(dict.get(key) == 1)
                return key;
        }
        
        return 0;
    }
}
