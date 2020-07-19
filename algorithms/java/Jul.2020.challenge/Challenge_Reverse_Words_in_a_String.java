class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        
        int end = s.length();
        int start = end - 1;
        
        while(start >= 0 && s.charAt(start) == ' ')
            --start;
        
        if(start < 0)
            return "";
        
        end = start + 1;
        
        while(start >= 0) {
            while(start >= 0 && s.charAt(start) != ' ')
                --start;
            
            for(int i = start+1 ; i < end ; ++i)
                sb.append(s.charAt(i));
            sb.append(' ');
            
            while(start >= 0 && s.charAt(start) == ' ')
                --start;
            
            end = start + 1;
        }
        
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
