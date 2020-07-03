class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        cost = [100000 for _ in range(n)]
        cost[src] = 0
        
        for i in range(K+1):
            tmp = cost[:]
            for flight in flights:
                cur, nex, pri = flight
                
                if cost[cur] == 100000:
                    continue
                
                if tmp[nex] > cost[cur] + pri:
                    tmp[nex] = cost[cur] + pri
            
            cost = tmp
        
        return cost[dst] if not cost[dst] == 100000 else -1
