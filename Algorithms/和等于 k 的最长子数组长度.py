class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        sum2index = {0: -1}
        cur_sum = 0
        result = 0
        for i, num in enumerate(nums):
            cur_sum += num
            if (cur_sum - k) in sum2index:
                result = max(result, i - sum2index[cur_sum - k])
            if cur_sum not in sum2index:
                sum2index[cur_sum] = i

        return result
