// JAEWON KIM
class Solution {
    public static class Rep implements Comparable<Rep> {
        int idx;
        String src;
        String trg;
        
        public Rep(int idx, String src, String trg) {
            this.idx = idx;
            this.src = src;
            this.trg = trg;
        }
        
        @Override
        public int compareTo(Rep other) {
            return this.idx - other.idx;
        }
    }
    
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int N = indexes.length;
        Rep[] rep = new Rep[N];
        
        for(int i = 0 ; i < N ; ++i) {
            rep[i] = new Rep(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(rep);
        
        int ptr = 0;
        for(int idx = 0 ; idx < N ; ++idx) {
            for(; ptr < rep[idx].idx; ++ptr) {
                sb.append(S.charAt(ptr));
            }
            
            int tIdx = rep[idx].idx;
            String src = rep[idx].src;
            
            if(!S.substring(tIdx, tIdx+src.length()).equals(src)) {
                continue;
            }
            
            sb.append(rep[idx].trg);
            ptr += src.length();
        }
        
        for(int i = ptr; i < S.length() ; ++i) {
            sb.append(S.charAt(i));
        }
        
        return sb.toString();
    }
}
