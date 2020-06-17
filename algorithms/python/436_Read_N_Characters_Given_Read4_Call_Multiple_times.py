import queue
# The read4 API is already defined for you.
# def read4(buf: List[str]) -> int:

class Solution:
    def __init__(self):
        self.queue = queue.Queue()
    
    def read(self, buf: List[str], n: int) -> int:
        if n == 0:
            return 0
        
        count = 0
        while count < n:
            elem = self.getOrFillQueue()
            if not elem:
                break
            
            buf[count] = elem
            count += 1
        
        return count
    
    def getOrFillQueue(self):
        if not self.queue.empty():
            return self.queue.get()
        
        buf = ['','','','']
        count = read4(buf)
        
        if count == 0:
            return None
        
        for elem in buf:
            self.queue.put(elem)
        
        return self.queue.get()
