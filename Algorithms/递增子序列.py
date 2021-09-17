from collections import defaultdict

class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        index2results = defaultdict(list)
        for i in range(1, len(nums)):
            for j in range(i-1, -1, -1):
                if nums[i] < nums[j]:
                    continue
                index2results[i].append([nums[j], nums[i]])
                for j_result in index2results[j]:
                    index2results[i].append(j_result + [nums[i]])

        result = set()
        for values in index2results.values():
            for value in values:
                result.add(tuple(value))
        return [list(_) for _ in result]