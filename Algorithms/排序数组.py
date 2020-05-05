class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        buckets = collections.defaultdict(int)
        min_value = nums[0]
        max_value = nums[0]
        for num in nums:
            min_value = min(min_value, num)
            max_value = max(max_value, num)
            buckets[num] += 1
        result = []
        for i in range(min_value, max_value + 1):
            if i not in buckets:
                continue
            result.extend([i] * buckets[i])
        return result;
