class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 1)
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        if(K == 0) {
            int base = 1;
            int[] retArr = new int[9];
            for(int i = 0 ; i < N-1 ; ++i)
                base = base*10 + 1;
                
            for(int i = 1 ; i < 10 ; ++i)
                retArr[i-1] = base*i;
            
            return retArr;
        }
            
        
        List<Integer> retList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < 10 ; ++i)
            q.offer(i);
        
        double cmp = Math.pow(10, N-1);
        while(q.size() != 0) {
            int tmp = q.poll();
            
            if(tmp / cmp >= 1) {
                retList.add(tmp);
                continue;
            }
            
            if(tmp%10 + K < 10)
                q.offer(tmp*10 + tmp%10 + K);
            
            if(tmp%10 - K >= 0)
                q.offer(tmp*10 + tmp%10 - K);
        }
        
        int idx = 0;
        int[] retArr = new int[retList.size()];
        for(int tmp: retList) {
            retArr[idx++] = tmp;
        }
        
        return retArr;
    }
}
