import java.util.regex.Pattern;

class Solution {
    public String validIPAddress(String IP) {
        String ipv4Pat = "^(?:(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$";
        String ipv6Pat = "^([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}$";
        
        if(Pattern.matches(ipv4Pat, IP))
            return "IPv4";
        else if(Pattern.matches(ipv6Pat, IP))
            return "IPv6";
        
        return "Neither";
    }
}
