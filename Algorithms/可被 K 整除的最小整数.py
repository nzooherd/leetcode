class Solution:
    def smallestRepunitDivByK(self, K: int) -> int:
        if K % 2 == 0 or K % 5 == 0:
            return -1
        slow_mod = 0
        quick_mod = 0
        result = 0
        while True:
            result += 1
            slow_mod = (slow_mod * 10 + 1) % K
            if slow_mod == 0:
                return result
            quick_mod = (quick_mod * 10 +1) % K
            quick_mod = (quick_mod * 10 + 1) % K
            if quick_mod == slow_mod:
                return -1