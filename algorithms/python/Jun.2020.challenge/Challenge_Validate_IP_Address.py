import re

class Solution:
    def validIPAddress(self, IP: str) -> str:
        ipv4Pat = "^(?:(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$"
        if re.compile(ipv4Pat).match(IP):
            return "IPv4"
        
        ipv6Pat = "^([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}$"
        if re.compile(ipv6Pat).match(IP):
            return "IPv6"
        
        return "Neither"
