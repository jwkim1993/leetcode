class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> permList = new ArrayList<>(n);
        int perm = 1;
        String retStr = "";
        
        for(int i = 1 ; i < n ; ++i) {
            permList.add(i);
            perm *= i;
        }
        permList.add(n);
        
        for(int i = n-1 ; i > 0 ; --i) {
            retStr += Integer.toString(permList.remove((k-1)/perm));
            k -= perm*((k-1)/perm);
            perm /= i;
        }
        retStr += Integer.toString(permList.remove(0));
        return retStr;
    }
}
