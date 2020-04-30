class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        if len(costs) == 1:
            return min(costs[0])
        
        results = costs[0]
        for i in range(1, len(costs)):
            new_results = [costs[i][0] + min(results[1], results[2]),
                                    costs[i][1] + min(results[0], results[2]),
                                    costs[i][2] + min(results[0], results[1])]
            results = new_results
        return min(results)
