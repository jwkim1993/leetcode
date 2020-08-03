class Solution {
    public boolean isPalindrome(String s) {
        List<Character> palin = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; ++i) {
            char tmp = s.charAt(i);
            if(('a' <= tmp && tmp <= 'z') || ('0' <= tmp && tmp <= '9')) {
                palin.add(tmp);
            } else if('A' <= tmp && tmp <= 'Z') {
                palin.add((char)(tmp+32));
            }
        }
        
        int N = palin.size();
        for(int i = 0 ; i < N/2 ; ++i) {
            if(palin.get(i) != palin.get(N-i-1))
                return false;
        }
        
        return true;
    }
}
