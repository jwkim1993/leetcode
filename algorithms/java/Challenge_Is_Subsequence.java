class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        int Ns = s.length();
        int Nt = t.length();
        
        while(sIdx < Ns && tIdx < Nt) {
            if(s.charAt(sIdx) == t.charAt(tIdx))
                sIdx++;
            tIdx++;
        }
        
        if(sIdx == Ns)
            return true;
        return false;
    }
}
