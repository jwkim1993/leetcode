class RandomizedSet {

    private Map<Integer, Integer> storedData;
    private List<Integer> dataList;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        storedData = new HashMap<>();
        dataList = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(storedData.get(val) != null)
            return false;
        
        storedData.put(val, dataList.size());
        dataList.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = storedData.remove(val);
        if(idx == null)
            return false;
        
        int lastIdx = dataList.size() - 1;
        if(idx != lastIdx) {
            storedData.put(dataList.get(lastIdx), idx);
            dataList.set(idx, dataList.get(lastIdx));
        }
        
        dataList.remove(lastIdx);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return dataList.get(random.nextInt(dataList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
