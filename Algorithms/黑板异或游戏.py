class Solution:
    def xorGame(self, nums: List[int]) -> bool:
        import collections
        num2fre = collections.defaultdict(int)
        for num in nums:
            num2fre[num] += 1

        sum_num = 0
        or_reuslt = 0
        for key, value in num2fre.items():
            sum_num += value % 2
            if value % 2 == 1:
                or_reuslt ^= key

        return sum_num % 2 == 0 or (or_reuslt == 0)