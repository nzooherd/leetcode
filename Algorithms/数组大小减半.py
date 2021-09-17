from collections import defaultdict

class Solution(object):
    def minSetSize(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        if not arr:
            return -1
        num2count = defaultdict(int)
        for num in arr:
            num2count[num] += 1

        num2count_items = list(num2count.items())
        num2count_items.sort(key=lambda x: x[1], reverse=True)

        count, res = 0, 0
        for _, value in num2count_items:
            count += value
            res += 1
            if count >= len(arr) / 2:
                return res

        