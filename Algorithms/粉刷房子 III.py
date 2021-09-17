from functools import lru_cache

class Solution:

    @lru_cache(None)
    def minCostDo(self, houses, cur_index, pre_color, n, target):
        if not houses:
            return -1 if target else 0

        houses = list(houses)

        result = 10 ** 4 * (len(houses))
        cost = self.costs[cur_index]

        if houses[0] != 0:
            return self.minCostDo(tuple(houses[1:]), cur_index + 1, houses[0], n , \
                target - (1 if houses[0] != pre_color else 0))

        has_fill = sum([1 if _ != 0 else 0 for _ in houses[1:]])
        for i in range(1, n+1):
            next_target = target - (1 if i != pre_color else 0)
            next_result =  self.minCostDo(tuple(houses[1:]), cur_index + 1, i, n, next_target)
            if next_result != -1:
                result = min(result, cost[i-1] + next_result) 

        return result if result != (10 ** 4 * len(houses)) else -1

    def minCost(self, houses, cost, m: int, n: int, target: int) -> int:
        self.costs = cost
        result = self.minCostDo(tuple(houses), 0, -1, n, target)
        return result