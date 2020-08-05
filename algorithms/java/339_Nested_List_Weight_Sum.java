class Solution {
    public int depthSum(List<NestedInteger> nestedList) {        
        return sumDepthList(nestedList, 1);
    }
    
    public int sumDepthList(List<NestedInteger> nestedList, int depth) {
        int resVal = 0;
        
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                resVal += depth * ni.getInteger();
                continue;
            }
            
            resVal += sumDepthList(ni.getList(), depth+1);
        }
        
        return resVal;
    }
}
