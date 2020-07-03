class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        N = len(costs)
        
        costs.sort(key=lambda cost: cost[0] - cost[1])
        return sum([c[0] for c in costs[:N//2]]) + sum([c[1]  for c in costs[N//2:]])
