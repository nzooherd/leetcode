class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        if not target:
            return 0
        res = target[0]
        for i in range(1, len(target)):
            if target[i] <= target[i-1]:
                continue
            res += target[i] - target[i-1]
        return res
