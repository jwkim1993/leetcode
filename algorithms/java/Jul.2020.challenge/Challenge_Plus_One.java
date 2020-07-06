class Solution {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        
        int carry = 1;
        for(int i = N-1 ; i >= 0 ; --i) {
            int newCarry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            
            if(newCarry == 0)
                return digits;
            
            carry = newCarry;
        }
        
        if(carry == 1) {
            int[] tmp = new int[N+1];
            for(int i = 0 ; i < N ; ++i)
                tmp[i+1] = digits[i];
            tmp[0] = 1;
            digits = tmp;
        }
        
        return digits;
    }
}
