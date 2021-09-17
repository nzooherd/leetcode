class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        result = []
        cur_sum = 0
        for num in nums:
            cur_sum += num
            result.append(cur_sum)
        return result