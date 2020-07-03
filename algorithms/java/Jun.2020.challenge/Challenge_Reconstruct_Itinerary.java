class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //tickets.sort((x, y) -> x.get(1).compareTo(y.get(1)));
        //tickets.forEach(x -> System.out.println(x));
        
        for(List<String> ticket : tickets) {
            if(!ticketMap.containsKey(ticket.get(0)))
                ticketMap.put(ticket.get(0), new PriorityQueue<>());
            
            ticketMap.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        recurItinerary("JFK");
        Collections.reverse(retList);
        
        return retList;
    }
    
    private void recurItinerary(String key) {
        PriorityQueue<String> pq = ticketMap.get(key);
        
        while(pq != null && !pq.isEmpty()) {
            recurItinerary(pq.poll());
        }
        
        retList.add(key);
    }
    
    private Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
    private List<String> retList = new ArrayList<>();
}
