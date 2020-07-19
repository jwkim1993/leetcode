class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        
        double result = recurPow(x, n);
        
        return n > 0 ? result : 1.0/result;
    }
    
    public double recurPow(double x, int n) {
        if(n == 1 || n == -1)
            return x;
        
        double retVal = recurPow(x, n/2);
        
        if(n%2 == 0)
            return retVal*retVal;
        else
            return retVal*retVal * x;
    }
}
