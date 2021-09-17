class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        indexs = []
        for i in range(0, len(nums)):
            if nums[i] == target:
                indexs.append(i)
        
        return min(map(lambda i: abs(i - start), indexs))

