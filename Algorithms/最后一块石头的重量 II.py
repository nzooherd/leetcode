class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        weight_sum = sum(stones) 
        res = [0] * (weight_sum // 2 + 1)
        print(res)
        for i in range(0, len(stones)):
            for j in range(len(res) - 1, 0, -1):
                res[j] = max((stones[i] + res[j - stones[i]]) if j >= stones[i] else 0, res[j])
        return weight_sum - 2 * res[-1]
            

