class RandomizedSet {

    private Map<Integer, Integer> storedData;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        storedData = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = storedData.get(val) != null ? false : true;
        storedData.put(val, 1);
        return ret;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return storedData.remove(val) != null ? true : false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = random.nextInt(storedData.size());
        return new ArrayList<Integer>(storedData.keySet()).get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
