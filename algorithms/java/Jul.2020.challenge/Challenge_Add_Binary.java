class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String maxVal = a.length() > b.length() ? a : b;
        String minVal = maxVal == a ? b : a;
        int lenDiff = maxVal.length() - minVal.length();
        
        char carry = '0';
        for(int i = minVal.length()-1 ; i >= 0 ; --i) {
            char maxBit = maxVal.charAt(i+lenDiff);
            char minBit = minVal.charAt(i);
            
            if(maxBit == '0' && minBit == '0') {
                sb.append(carry);
                carry = '0';
            } else if(maxBit == '1' && minBit == '1') {
                sb.append(carry);
                carry = '1';
            } else {
                sb.append(carry == '1' ? '0' : '1');
                // carry not be changed
            }
        }
        
        for(int i = lenDiff - 1 ; i >= 0 ; --i) {
            if(carry == '0') {
                sb.append(maxVal.charAt(i));
            } else if(maxVal.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
                carry = '0';
            }
        }
        
        if(carry == '1') {
            sb.append('1');
        }
        
        sb.reverse();
        
        return sb.toString();
        
    }
}
