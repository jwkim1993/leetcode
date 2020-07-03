class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        methods = [0 for i in range(amount+1)]
        methods[0] = 1
        
        for coin in coins:
            for i in range(coin, amount+1):
                methods[i] += methods[i-coin]

        return methods[-1]
