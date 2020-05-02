class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sum2frequency = {0: 1}
        s = 0
        result = 0
        for num in nums:
            s += num
            result += sum2frequency.get(s - k, 0)
            if s not in sum2frequency:
                sum2frequency[s] = 0
            sum2frequency[s] += 1
        return result
           
        