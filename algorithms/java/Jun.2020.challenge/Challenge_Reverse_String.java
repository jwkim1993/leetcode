class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2 ; ++i) {
            s[i] += s[s.length-i-1];
            s[s.length-i-1] = (char)(s[i] - s[s.length-i-1]);
            s[i] = (char)(s[i] - s[s.length-i-1]);
        }
    }
}
