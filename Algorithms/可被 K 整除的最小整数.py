class Solution(object):
    def smallestRepunitDivByK(self, K):
        """
        :type K: int
        :rtype: int
        """
        if K % 2 == 0 or K % 5 == 0:
            return -1
        num = 1
        digit = 0
        while True:
            digit += 1
            if num % K == 0:
                return digit
            num = num % K
            num = num * 10 + 1
