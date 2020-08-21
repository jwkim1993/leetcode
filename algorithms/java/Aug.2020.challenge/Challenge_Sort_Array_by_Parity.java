class Solution {
    public int[] sortArrayByParity(int[] A) {
        int idx = 0;
        int oddPtr = A.length - 1;
        
        while(idx < oddPtr) {
            while(oddPtr > idx && A[idx]%2 == 1) { //swap
                A[idx] += A[oddPtr];
                A[oddPtr] = A[idx] - A[oddPtr];
                A[idx] -= A[oddPtr];
                --oddPtr;
            }
            ++idx;
        }
        
        return A;
    }
}
