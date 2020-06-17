/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private Queue<Character> queue;
    
    public Solution() {
        queue = new LinkedList<>();
    }
    
    public int read(char[] buf, int n) {
        if(n == 0)
            return 0;
        
        int count = 0;
        while(count < n) {
            char elem = getOrFillQueue();
            if(elem == 0)
                return count;
            
            buf[count++] = elem;
        }
        
        return count;
    }
    
    public char getOrFillQueue() {
        if(queue.peek() != null)
            return queue.poll();
        
        char[] buf = new char[4];
        if(read4(buf) == 0)
            return 0;
        
        // there is no charStream
        // Arrays.stream(buf).forEach(x -> queue.offer(x));
        
        for(char elem: buf)
            queue.offer(elem);
        
        return queue.poll();
        
    }
}
