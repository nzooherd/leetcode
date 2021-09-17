from functools import lru_cache

class Solution:

    def minInteger(self, num: str, k: int) -> str:
        if k <= 0 or not num:
            return num

        for i in range(0, 10):
            index = num.find(str(i))
            if index < 0:
                continue
            if index <= k:
                if k == index:
                    return str(i) + num[0:index] + num[index+1:]
                return str(i) + self.minInteger(num[0:index] + num[index+1:], k - index)
        return num
